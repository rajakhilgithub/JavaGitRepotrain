package net.opentrends.carrental.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.carrental.model.Login;

@Component
public class LoginValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object obj, Errors error) {
		// TODO Auto-generated method stub
		Login login=(Login)obj;
		String username=login.getUsername();
		String password=login.getPwd();
		if(username.isEmpty()) {
			error.rejectValue("username", "username.empty", "Username should not be null");
		}
		if(password.isEmpty()) {
			error.rejectValue("pwd", "password.empty", "Password should not be null");
		}
	}

}
