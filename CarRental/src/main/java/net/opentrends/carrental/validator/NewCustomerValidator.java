package net.opentrends.carrental.validator;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.carrental.DAOServices.CustomerDAOService;
import net.opentrends.carrental.model.Customer;
@Component
public class NewCustomerValidator implements Validator {
@Autowired
CustomerDAOService customerService;
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		// TODO Auto-generated method stub
		Customer customer=(Customer)arg0;
		if(customer.getCustomerName().isEmpty()) {
			error.rejectValue("customerName", "customer.nameempty", "Customer name should not be null");
		}
		if(customer.getPlace().isEmpty()) {
			error.rejectValue("place", "customer.placeempty", "Place should not be null");
		}
		List<Customer> customers=customerService.listAll();
		for(Iterator<Customer> i=customers.iterator();i.hasNext();) {
			Customer customer1=i.next();
			if(customer1.getCustomerName().equalsIgnoreCase(customer.getCustomerName())&&customer1.getPlace().equalsIgnoreCase(customer.getPlace())) {
				error.rejectValue("customerName", "customer.placeexist", "Customer place combination already exists");
			}
		
		}
		
	}

}
