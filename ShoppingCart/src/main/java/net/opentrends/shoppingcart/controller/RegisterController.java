package net.opentrends.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.opentrends.shoppingcart.dto.Login;
import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.service.BuyerService;
import net.opentrends.shoppingcart.service.EmailExistService;
import net.opentrends.shoppingcart.service.SellerService;
import net.opentrends.shoppingcart.validator.RegisterValidator;

@Controller
public class RegisterController {

	
	@Autowired
	SellerService sellerService;
	@Autowired
	BuyerService buyerService;
	@Autowired
	EmailExistService emailExist;
	RegisterValidator registerValidator=new RegisterValidator();
	
	@RequestMapping(value="/newRegistration")
	public ModelAndView newRegistrationForm() {
		return new ModelAndView("newRegistration","registration", new RegistrationDto());
	}
	@RequestMapping(value="/validateRegistration")
	public String newRegistrationValidation(@ModelAttribute("registration")RegistrationDto registerDto,BindingResult result,Model model) {
		registerValidator.validate(registerDto, result);
		if(result.hasErrors()) {
			return "newRegistration";
		}else {
			if(!(emailExist.findExists(registerDto))){
			if(registerDto.getType().equals("seller")) {
				sellerService.saveOrUpdate(registerDto);
			}else {
				buyerService.saveOrUpdate(registerDto);
			}
			model.addAttribute("successMessage", registerDto.getType()+" Registration Successfull");
				model.addAttribute("loginForm", new Login());
				return "login";

		}else {
			model.addAttribute("errorMessage", "Email already Exist");
			return "newRegistration";

		}
		}
	}
}
