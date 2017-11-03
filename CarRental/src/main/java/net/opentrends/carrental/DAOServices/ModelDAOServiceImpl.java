package net.opentrends.carrental.DAOServices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.carrental.DAOClasses.BrandDAO;
import net.opentrends.carrental.DAOClasses.ModelDAO;
import net.opentrends.carrental.DTOClasses.ModelFormDTO;
import net.opentrends.carrental.model.Brand;
import net.opentrends.carrental.model.Model;
import net.opentrends.carrental.model.Rent;
@Service
public class ModelDAOServiceImpl implements ModelDAOService {

	@Autowired
	ModelDAO modelDao;
	@Autowired
	BrandDAO brandDao;
	@Autowired
	BrandDAOService brandService;
	@Autowired
	ModelDAOService modelService;
	@Override
	@Transactional
	public List listAll() {
		// TODO Auto-generated method stub
		return this.modelDao.listAll();
	}

	@Override
	@Transactional
	public Model save(Model model) {
		// TODO Auto-generated method stub
		return this.modelDao.save(model);
	}

	@Override
	@Transactional
	public void delete(Model model) {
		// TODO Auto-generated method stub
		this.modelDao.delete(model);
	}

	@Override
	@Transactional
	public Model findByKey(int id) {
		// TODO Auto-generated method stub
		return this.modelDao.findByKey(id);
	}

	@Override
	@Transactional
	public Model findByName(String name) {
		// TODO Auto-generated method stub
		return this.modelDao.findByName(name);
	}

	@Override
	@Transactional
	public String addVehicle(ModelFormDTO modelDTO) {
		// TODO Auto-generated method stub
		Rent rent=new Rent(modelDTO.getDailyRent());
		Model model=new Model(modelDTO.getModelName(), modelDTO.getStock(), rent);
		Brand brand=brandService.findByName(modelDTO.getBrandName());
		model.setBrand(brand);
		rent.setModel(model);
		modelService.save(model);
		return("Vehicle Added Succesfully");
	}

	@Override
	@Transactional
	public List getModelListByBranchId(int brandId) {
		return this.modelDao.getModelListByBranchId(brandId);
	}

}
