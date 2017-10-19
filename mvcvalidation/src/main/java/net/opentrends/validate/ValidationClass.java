package net.opentrends.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidationClass implements Validator {
	
	private Pattern pattern;
	Matcher match;
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object arg0, Errors er) {
		// TODO Auto-generated method stub
		Login log=(Login)arg0;
		String uname=log.getUsername();
		String pwd=log.getPwd();
		if(uname.isEmpty()) {
		er.rejectValue("username","username.empty", "Should not be left null");	
		}
		if(pwd.isEmpty()) {
			er.rejectValue("pwd","password.empty", "Should not be left null");	
			}
		/*pattern=Pattern.compile(refPattern,Pattern.CASE_INSENSITIVE);
		match=pattern.matcher(uname);
		if(!(match.matches())) {
			er.rejectValue("username", "username.unmatch", "Username has invalid or insufficient characters");
		}*/
	}

}
