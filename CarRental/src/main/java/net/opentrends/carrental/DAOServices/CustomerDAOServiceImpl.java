package net.opentrends.carrental.DAOServices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.carrental.DAOClasses.CustomerDAO;
import net.opentrends.carrental.model.Customer;
@Service
public class CustomerDAOServiceImpl implements CustomerDAOService {
	
@Autowired
private CustomerDAO customerDao;
	@Override
	@Transactional
	public List listAll() {
		// TODO Auto-generated method stub
		return this.customerDao.listAll();
	}

	@Override
	@Transactional
	public void delete(Customer customer) {
		this.customerDao.delete(customer);
		
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return this.customerDao.save(customer);
	}

	@Override
	@Transactional
	public Customer findByKey(int id) {
		// TODO Auto-generated method stub
		return this.customerDao.findByKey(id);
	}

}
