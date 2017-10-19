package net.opentrends.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.BindStatus;

@Controller
public class Logincontroller {
@Autowired
private AuthenticationService auth;
@Autowired
private ValidationClass loginValidator;

	@RequestMapping(value="/logform")
	public ModelAndView logform() {
		return new ModelAndView("logform","command",new Login());
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public String validate(@ModelAttribute("command")@Validated Login log,BindingResult validresult,Model model) {
		loginValidator.validate(log, validresult);
		if(validresult.hasErrors()) {
				return "logform";
		}else {
			Boolean result=auth.authenticate(log.getUsername(), log.getPwd());
			if(result) {
				return "display";
			}else {
				model.addAttribute("message", "invalid username or password");
				return "logform";
			}
		}
	}
}