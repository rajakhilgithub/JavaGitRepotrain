package net.opentrends.carrental.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.carrental.DTOClasses.BookingDTO;

@Component
public class NewBookingValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		BookingDTO bookingDto=(BookingDTO)target;
		if(bookingDto.getCustomerId()==0) {
			errors.rejectValue("customerId", "customer.empty","select a customer");
		}
	}

}
