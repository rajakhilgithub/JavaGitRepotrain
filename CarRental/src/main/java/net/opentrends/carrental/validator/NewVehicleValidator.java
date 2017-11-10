package net.opentrends.carrental.validator;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.opentrends.carrental.DAOServices.ModelDAOService;
import net.opentrends.carrental.DTOClasses.ModelFormDTO;
import net.opentrends.carrental.model.Model;
@Component
public class NewVehicleValidator implements Validator{
@Autowired
ModelDAOService modelService;
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		// TODO Auto-generated method stub
		ModelFormDTO modelDTO=(ModelFormDTO)arg0;
		if(modelDTO.getBrandName().isEmpty()) {
			error.rejectValue("brandName", "brand.nameselect.empty", "Select a Brandname");
		}
		if(modelDTO.getModelName().isEmpty()) {
			error.rejectValue("modelName", "model.name.empty", "Enter a Model Name");
		}
		if(modelDTO.getStock()==0) {
			error.rejectValue("stock", "model.stock.empty", "Enter Stock");
		}
		if(modelDTO.getDailyRent()==0) {
			error.rejectValue("dailyRent", "model.rent.empty", "Enter Daily Rent");
		}
		List<Model> models=modelService.listAll();
		for(Iterator<Model> i=models.iterator();i.hasNext();) {
			Model model=i.next();
			if(model.getBrand().getName().equalsIgnoreCase(modelDTO.getBrandName())&&model.getModelNo().equalsIgnoreCase(modelDTO.getModelName())) {
				error.rejectValue("brandName", "model.brand.modelexist","Brand Model combination Exists");
			}
		}
	}

}
