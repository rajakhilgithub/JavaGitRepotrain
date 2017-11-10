package net.opentrends.shoppingcart.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.type.descriptor.java.SerializableTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.dto.SellerDto;
import net.opentrends.shoppingcart.service.BuyerService;
import net.opentrends.shoppingcart.service.SellerService;

public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistrationDto registerDto = (RegistrationDto) target;
		if (registerDto.getFirstName().isEmpty()) {
			errors.rejectValue("firstName", "firstname.empty", "default firstname empty");
		}
		if (registerDto.getLastName().isEmpty()) {
			errors.rejectValue("lastName", "lastname.empty", "default lastname empty");
		}
		if (registerDto.getEmailId().isEmpty()) {
			errors.rejectValue("emailId", "email.empty", "default email empty");
		}
		if (registerDto.getPassWord().isEmpty()) {
			errors.rejectValue("passWord", "password.empty", "default password empty");
		}
		if (registerDto.getType() == null) {
			errors.rejectValue("type", "type.empty", "default type empty");

		}

		String regularExpression = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		Pattern pattern = Pattern.compile(regularExpression);
		Matcher matcher = pattern.matcher(registerDto.getEmailId());
		if (!(matcher.matches())) {
			errors.rejectValue("emailId", "email.invalidFormat", "default invalid format message");
		}
	}

}
