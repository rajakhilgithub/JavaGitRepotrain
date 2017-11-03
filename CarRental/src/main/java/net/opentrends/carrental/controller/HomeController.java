package net.opentrends.carrental.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.opentrends.carrental.DAOServices.BookingDAOService;
import net.opentrends.carrental.DAOServices.BrandDAOService;
import net.opentrends.carrental.DAOServices.CustomerDAOService;
import net.opentrends.carrental.DAOServices.ModelDAOService;
import net.opentrends.carrental.DAOServices.RentDAOService;
import net.opentrends.carrental.DTOClasses.BookingDTO;
import net.opentrends.carrental.DTOClasses.ModelDTO;
import net.opentrends.carrental.DTOClasses.ModelFormDTO;
import net.opentrends.carrental.model.Booking;
import net.opentrends.carrental.model.Brand;
import net.opentrends.carrental.model.Customer;
import net.opentrends.carrental.model.Rent;
import net.opentrends.carrental.validator.NewBookingValidator;
import net.opentrends.carrental.validator.NewBrandValidator;
import net.opentrends.carrental.validator.NewCustomerValidator;
import net.opentrends.carrental.validator.NewSearchValidator;
import net.opentrends.carrental.validator.NewVehicleValidator;

@Controller
public class HomeController {

	
	@Autowired
	NewBrandValidator brandValidator;
	@Autowired
	NewCustomerValidator customerValidator;
	@Autowired
	NewVehicleValidator vehicleValidate;
	@Autowired
	NewSearchValidator searchValidate;
	@Autowired
	NewBookingValidator bookingValidator;
	@Autowired
	BrandDAOService brandAdd;
	@Autowired
	CustomerDAOService customerAdd;
	@Autowired
	BrandDAOService brandService;
	@Autowired
	ModelDAOService modelService;
	@Autowired
	BookingDAOService bookingservice;
	
	@RequestMapping(value="/home")
	String home() {
		return "home";
	}
	
	//Brand Insertion
	@RequestMapping(value = "/newbrand")
	ModelAndView newBrandForm() {
		return new ModelAndView("newbrand", "brandnew", new Brand());
	}

	@RequestMapping(value = "/validatebrand", method = RequestMethod.POST)
	String newBrandValidation(@ModelAttribute("brandnew") @Validated Brand brand, BindingResult result, Model model) {
		brandValidator.validate(brand, result);
		if (result.hasErrors()) {
			return "newbrand";
		} else {
			brandAdd.save(brand);
			model.addAttribute("successmessage", "Brand Added Succesfully");
			return "newbrand";
		}
	}

	//Customer Insertion
	@RequestMapping(value = "/newcustomer")
	ModelAndView newCustomerForm() {
		return new ModelAndView("newcustomer", "customernew", new Customer());
	}

	@RequestMapping(value = "/validatecustomer", method = RequestMethod.POST)
	String newCustomerValidation(@ModelAttribute("customernew") @Validated Customer customer, BindingResult result,
			Model model) {
		customerValidator.validate(customer, result);
		if (result.hasErrors()) {
			return "newcustomer";
		} else {
			customerAdd.save(customer);
			model.addAttribute("successmessage", "Customer Added Succesfully");
			return "newcustomer";
		}
	}

	//Model Insertion

	@RequestMapping(value = "/newmodel")
	ModelAndView newModelForm(Model model) {

		model.addAttribute("namelist", brandService.listAll());
		return new ModelAndView("newmodel", "modelnew", new ModelFormDTO());
	}

	@RequestMapping(value = "/validatevehicle", method = RequestMethod.POST)
	String newVehicleValidation(@ModelAttribute("modelnew") @Validated ModelFormDTO modelDTO, BindingResult result,
			Model model) {
		vehicleValidate.validate(modelDTO, result);
		if (result.hasErrors()) {
			model.addAttribute("namelist", brandService.listAll());
			return "newmodel";
		} else {

			model.addAttribute("successmessage", modelService.addVehicle(modelDTO));
			return "newmodel";
		}
	}

	// Search

	@RequestMapping(value = "/search")
	ModelAndView newSearchForm(Model model) {
		model.addAttribute("namelist", brandService.listAll());
		return new ModelAndView("search", "search", new BookingDTO());
	}
	
	@RequestMapping(value = "/getModelById")
	@ResponseBody
	List<ModelDTO> getModelById(@RequestParam(name="brandId") int brandId) {
//		System.out.println("brandId--"+brandId);
	    List<ModelDTO> model_list=modelService.getModelListByBranchId(brandId);
//		List<ModelDTO> dtoList = new ArrayList<ModelDTO>();
//		dtoList.add(new ModelDTO());
	    System.out.println("size--"+model_list.size());
		return model_list;
	}
	
	@RequestMapping(value="/validateSearch",method=RequestMethod.POST)
	String newSearchValidation(@ModelAttribute("search")@Validated BookingDTO bookingDto,BindingResult result,Model model,ModelMap modelMap) {
		String checkmessage=null;
		searchValidate.validate(bookingDto, result);
		if(result.hasErrors()) {
			model.addAttribute("namelist", brandService.listAll());
			return "search";
		}
		else {
			bookingDto=bookingservice.setDates(bookingDto);
			int available=bookingservice.findAvailable(bookingDto);
			String availMessage="";
			if(available==0) {
			availMessage="<p class=\"error\">No vehicles of this model available<p>";
			}else {
				availMessage="<p class=\"success\">"+available+" Vehicles available";
				model.addAttribute("cutomerList",customerAdd.listAll());
				checkmessage="success";
			}
			model.addAttribute("availablityMessage", availMessage);
			model.addAttribute("namelist", brandService.listAll());
			model.addAttribute("checkMessage", checkmessage);
			System.out.println(bookingDto.getFromDate().toString()+"--to--"+bookingDto.getToDate().toString());
			modelMap.put("bookingDto", bookingDto);
			return "search";
		}
		
	}
	
	//Booking
	
	@RequestMapping(value="/validateBooking")
	String newBookingForm(@ModelAttribute("search")@Validated BookingDTO bookingDto,BindingResult result,Model model,ModelMap modelMap) {
		System.out.println(bookingDto.getModelId()+"---"+bookingDto.getBrandId()+"---"+bookingDto.getCustomerId()+"----"+bookingDto.getFromDate()+"---"+bookingDto.getfDate());
		bookingValidator.validate(bookingDto, result);
		if(result.hasErrors()) {
		model.addAttribute("cutomerList",customerAdd.listAll());
		model.addAttribute("checkMessage", "success");
		modelMap.put("bookingDto", bookingDto);
		return "search";
		}
		else {
			bookingDto=bookingservice.setDates(bookingDto);	
			bookingservice.save(bookingDto);
			model.addAttribute("successmessage", "Booking Succesfull");
			model.addAttribute("cutomerList",customerAdd.listAll());
			return "search";
		}
		
	}
	
}
