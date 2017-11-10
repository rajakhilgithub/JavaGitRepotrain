package net.opentrends.carrental.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.opentrends.carrental.model.Login;
import net.opentrends.carrental.service.LoginAuthentication;
import net.opentrends.carrental.validator.LoginValidator;

@Controller
public class LoginController {
@Autowired
private LoginValidator loginvalidate;
@Autowired
private LoginAuthentication authenticate;
@RequestMapping(value="/login")
public ModelAndView login(HttpSession httpSession) {
	httpSession.setAttribute("user", "");
	return new ModelAndView("login","loginCommand",new Login());
}
@RequestMapping(value="/validatelogin",method=RequestMethod.POST)
public String loginValidate(@ModelAttribute("loginCommand")@Validated Login login,BindingResult errorResult,Model model,HttpSession httpSession) {
	loginvalidate.validate(login, errorResult);
	if(errorResult.hasErrors()) {
		return "login";
	}
	else {
		boolean authResult=authenticate.authenticate(login.getUsername(), login.getPwd());
		if(authResult) {
			httpSession.setAttribute("user", login.getUsername());
			return "home";
		}else {
			model.addAttribute("message", "invalid username or password");
			return "login";
		}
	}
}
@RequestMapping(value="/logout")
public ModelAndView logout(HttpSession httpSession) {
	System.out.println("logged out");
	httpSession.setAttribute("user","");

	return new ModelAndView("login","loginCommand",new Login());
}
}
