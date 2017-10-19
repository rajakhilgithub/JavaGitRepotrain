package net.opentrends.formprocess;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Mvcformcontroller {
	@RequestMapping("/webform")
		public ModelAndView showform() {
			return new ModelAndView("webform","command",new Employee());
		}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveform(@RequestAttribute("emp")Employee emp,ModelMap model) {
		model.addAttribute("empno", emp.getEmpno());
		model.addAttribute("name", emp.getName());
		model.addAttribute("desig", emp.getDesig());
		model.addAttribute("sal", emp.getSalary());
		
		return "display";
	}
	

}
