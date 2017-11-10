package net.opentrends.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.Login;
import net.opentrends.shoppingcart.dto.ProductDto;
import net.opentrends.shoppingcart.dto.SellerDto;
import net.opentrends.shoppingcart.service.BuyerService;
import net.opentrends.shoppingcart.service.LoginAuthenticationService;
import net.opentrends.shoppingcart.service.ProductService;
import net.opentrends.shoppingcart.service.SellerService;
import net.opentrends.shoppingcart.validator.LoginValidator;

@Controller
public class loginController {

	LoginValidator loginValidator = new LoginValidator();
	@Autowired
	LoginAuthenticationService authenticationService;
	@Autowired
	SellerService sellerService;
	@Autowired
	ProductService productService;
	@Autowired
	BuyerService buyerService;

	@RequestMapping(value = "/login")
	public ModelAndView newLoginPage(HttpSession httpSession) {
		httpSession.setAttribute("username", "");
		return new ModelAndView("login", "loginForm", new Login());
	}

	@RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
	public String loginFormValidate(@ModelAttribute("loginForm") Login loginData, BindingResult result, Model model,
			HttpSession httpSession) {
		loginValidator.validate(loginData, result);
		if (result.hasErrors()) {
			return "login";
		} else {
			if (authenticationService.authenticate(loginData)) {
				httpSession.setAttribute("username", loginData.getUsername());
				if (loginData.getType().equals("seller")) {

					SellerDto sellerDto = sellerService.getSellerByEmail(loginData.getUsername());
					List<ProductDto> productList = productService.getProductsBySellerId(sellerDto.getSellerId());
					model.addAttribute("productList", productList);
					model.addAttribute("sellerName", sellerDto.getFirstName());
					return "sellerHome";
				} else {
					BuyerDto buyerDto = buyerService.getBuyerByEmail(loginData.getUsername());
					List<ProductDto> productList = productService.listAll();
					model.addAttribute("productList", productList);
					model.addAttribute("buyerName", buyerDto.getFirstName());
					return "buyerHome";
				}
			} else {
				model.addAttribute("errorMessage", "Invalid EmailId or Password");
				return "login";
			}
		}

	}

	@RequestMapping(value = "/logout")
	public String logoutPage(HttpSession httpSession, Model model) {
		httpSession.setAttribute("username", "");
		model.addAttribute("loginForm", new Login());
		return "login";
	}
}
