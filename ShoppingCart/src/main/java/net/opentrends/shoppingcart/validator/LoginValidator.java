package net.opentrends.shoppingcart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.shoppingcart.dto.Login;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Login loginData = (Login) target;
		if (loginData.getUsername().isEmpty()) {
			errors.rejectValue("username", "username.empty", "default username empty message");
		}
		if (loginData.getPassWord().isEmpty()) {
			errors.rejectValue("passWord", "password.empty", "default password empty message");
		}
		if (loginData.getType() == null) {
			errors.rejectValue("type", "type.empty", "default type empty message");
		}
	}

}
