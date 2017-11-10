package net.opentrends.shoppingcart.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.shoppingcart.dto.ProductDto;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductDto productDto = (ProductDto) target;
		if (productDto.getProductName().isEmpty()) {
			errors.rejectValue("productName", "productname.empty", "default product name empty message");
		}
		if (productDto.getProductPrice() == null) {
			errors.rejectValue("productPrice", "productprice.empty", "default product price empty message");
		}
	}

}
