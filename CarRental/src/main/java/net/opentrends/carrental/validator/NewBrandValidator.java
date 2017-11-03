package net.opentrends.carrental.validator;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.carrental.DAOServices.BrandDAOService;
import net.opentrends.carrental.model.Brand;

@Component
public class NewBrandValidator implements Validator{
	@Autowired
	BrandDAOService brandService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Brand brand=(Brand)obj;
		if(brand.getName().isEmpty()) {
			errors.rejectValue("name", "brand.nameempty", "Enter brand Name");
		}
		if(brand.getCountryOrigin().isEmpty()) {
			errors.rejectValue("countryOrigin", "brand.countryoriginempty", "Enter country of origin");
		}
		
		List<Brand> brandList=brandService.listAll();
		for(Iterator<Brand> i=brandList.iterator();i.hasNext();) {
			Brand brandObj=(Brand) i.next();
			
			if(brandObj.getName().equalsIgnoreCase(brand.getName())) {
				errors.rejectValue("name", "brand.nameexist", "Brandname Already exist");
			}
		}
			
	}

}
