package net.opentrends.carrental.DAOServices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.carrental.DAOClasses.BrandDAO;
import net.opentrends.carrental.model.Brand;
@Service
public class BrandDAOServiceImpl implements BrandDAOService {
	@Autowired
	private BrandDAO brandDao;
	
	
	

	@Override
	@Transactional
	public List listAll() {
		return this.brandDao.listAll();
	}

	@Override
	@Transactional
	public Brand save(Brand brand) {
		System.out.println("hai1");
		// TODO Auto-generated method stub
		return this.brandDao.save(brand);
	}

	@Override
	@Transactional
	public void delete(Brand brand) {
		this.brandDao.delete(brand);
		
	}

	@Override
	@Transactional
	public Brand findByKey(int id) {
		// TODO Auto-generated method stub
		return this.brandDao.findByKey(id);
	}

	@Override
	@Transactional
	public Brand findByName(String name) {
		// TODO Auto-generated method stub
		return this.brandDao.findByName(name);
	}

	@Override
	@Transactional
	public List listNames() {
		// TODO Auto-generated method stub
		return this.brandDao.listNames();
	}

}
