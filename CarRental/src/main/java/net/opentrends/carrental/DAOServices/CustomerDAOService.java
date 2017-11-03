package net.opentrends.carrental.DAOServices;

import java.util.List;

import net.opentrends.carrental.model.Customer;

public interface CustomerDAOService {

	public List listAll();
	public void delete(Customer customer);
	public Customer save(Customer customer);
	public Customer findByKey(int id);
}
