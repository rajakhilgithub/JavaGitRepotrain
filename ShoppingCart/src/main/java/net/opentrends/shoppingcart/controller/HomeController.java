package net.opentrends.shoppingcart.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.Login;
import net.opentrends.shoppingcart.dto.OrdersDto;
import net.opentrends.shoppingcart.dto.ProductDto;
import net.opentrends.shoppingcart.dto.SellerDto;
import net.opentrends.shoppingcart.service.BuyerService;
import net.opentrends.shoppingcart.service.OrdersService;
import net.opentrends.shoppingcart.service.ProductService;
import net.opentrends.shoppingcart.service.SellerService;
import net.opentrends.shoppingcart.validator.ProductValidator;

@Controller
public class HomeController {

	@Autowired
	ProductService productService;
	@Autowired
	SellerService sellerService;
	@Autowired
	BuyerService buyerService;
	@Autowired
	OrdersService ordersService;

	@RequestMapping(value = "/sellerHome")
	public String newSellerHome(Model model, HttpSession httpSession) {
		String userMail = httpSession.getAttribute("username").toString();
		SellerDto sellerDto = sellerService.getSellerByEmail(userMail);
		List<ProductDto> productList = productService.getProductsBySellerId(sellerDto.getSellerId());
		model.addAttribute("productList", productList);
		model.addAttribute("sellerName", sellerDto.getFirstName());
		return "sellerHome";
	}

	@RequestMapping(value = "/addProduct")
	public String newAddProductForm(Model model, HttpSession httpSession) {
		model.addAttribute("addProductForm", new ProductDto());
		String userMail = httpSession.getAttribute("username").toString();
		SellerDto sellerDto = sellerService.getSellerByEmail(userMail);
		model.addAttribute("sellerName", sellerDto.getFirstName());
		return "addProduct";
	}

	@RequestMapping(value = "/addValidate", method = RequestMethod.POST)
	public String validateAndAddProduct(@ModelAttribute("addProductForm") ProductDto productDto, BindingResult result,
			Model model, HttpSession httpSession) {
		ProductValidator productValidator = new ProductValidator();
		productValidator.validate(productDto, result);
		String userMail = httpSession.getAttribute("username").toString();
		SellerDto sellerDto = sellerService.getSellerByEmail(userMail);

		if (result.hasErrors()) {
			model.addAttribute("sellerName", sellerDto.getFirstName());
			return "addProduct";
		} else {
			if (!(productService.findProductExists(productDto))) {
				
				productDto.setSellerId(sellerDto.getSellerId());
				productService.saveOrUpdate(productDto);
				if(productDto.getProductIdentity()==null) {
				model.addAttribute("successMessage", "Product Added Successfully");
				}else {
					model.addAttribute("successMessage", "Product Edited Successfully");

				}
			} else {
				model.addAttribute("productExistMessage", "Product Already Exist");
			}
			model.addAttribute("sellerName", sellerDto.getFirstName());
			return "addProduct";
		}
	}

	@RequestMapping(value = "/editProduct")
	public String editToAddPage(@RequestParam("productId") int productId, Model model,HttpSession httpSession) {
		ProductDto productDto = productService.findById(productId);
		model.addAttribute("addProductForm", productDto);
		String userMail = httpSession.getAttribute("username").toString();
		SellerDto sellerDto = sellerService.getSellerByEmail(userMail);
		model.addAttribute("sellerName", sellerDto.getFirstName());
		return "addProduct";
	}

	@RequestMapping(value = "/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId, Model model, HttpSession httpSession) {
		productService.delete(productId);
		model.addAttribute("deleteMessage", "Product Deleted");
		String userMail = httpSession.getAttribute("username").toString();
		SellerDto sellerDto = sellerService.getSellerByEmail(userMail);
		List<ProductDto> productList = productService.getProductsBySellerId(sellerDto.getSellerId());
		model.addAttribute("productList", productList);
		model.addAttribute("sellerName", sellerDto.getFirstName());
		return "sellerHome";
	}

	@RequestMapping(value = "/buyerHome")
	public String newBuyerHome(Model model, HttpSession httpSession) {
		String userMail = httpSession.getAttribute("username").toString();
		BuyerDto buyerDto = buyerService.getBuyerByEmail(userMail);
		List<ProductDto> productList = productService.listAll();
		model.addAttribute("productList", productList);
		model.addAttribute("buyerName", buyerDto.getFirstName());
		return "buyerHome";
	}

	@RequestMapping(value = "/buyProduct")
	public String saveAndLoadOrders(@RequestParam("productId") int productId, Model model, HttpSession httpSession) {
		String userMail = httpSession.getAttribute("username").toString();
		BuyerDto buyerDto = buyerService.getBuyerByEmail(userMail);
		ProductDto productDto = productService.findById(productId);
		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setOrderNumber(UUID.randomUUID().toString());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		ordersDto.setOrderDate(dateFormat.format(date));
		ordersDto.setBuyerId(buyerDto.getBuyerId());
		ordersDto.setProductName(productDto.getProductName());
		ordersService.saveOrUpdate(ordersDto);

		List<OrdersDto> ordersList = ordersService.listByBuyerId(buyerDto.getBuyerId());
		model.addAttribute("orderList", ordersList);
		model.addAttribute("buyerName", buyerDto.getFirstName());

		return "orderList";

	}

	@RequestMapping(value = "/orderList")
	public String newOrderListPage(Model model, HttpSession httpSession) {
		String userMail = httpSession.getAttribute("username").toString();
		BuyerDto buyerDto = buyerService.getBuyerByEmail(userMail);
		List<OrdersDto> ordersList = ordersService.listByBuyerId(buyerDto.getBuyerId());
		model.addAttribute("orderList", ordersList);
		model.addAttribute("buyerName", buyerDto.getFirstName());

		return "orderList";
	}
}
