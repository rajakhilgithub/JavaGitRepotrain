package net.opentrends.carrental.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.carrental.DTOClasses.BookingDTO;

@Component
public class NewSearchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		BookingDTO bookingDto=(BookingDTO) target;
		if(bookingDto.getBrandId()== null) {
			errors.rejectValue("brandId", "brand.nameselect.empty", "select a brand");
		}
		if(bookingDto.getModelId()== null) {
			errors.rejectValue("modelId", "model.nameselect.empty", "select a model");
		}
		if(bookingDto.getfDate().isEmpty()) {
			errors.rejectValue("fDate", "search.fromDate.empty", "Enter Starting Date");
		}
		if(bookingDto.gettDate().isEmpty()) {
			errors.rejectValue("tDate", "search.toDate.empty", "Enter Ending Date");
		}
	}

}
