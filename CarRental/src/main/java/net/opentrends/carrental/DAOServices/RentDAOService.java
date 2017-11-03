package net.opentrends.carrental.DAOServices;

import java.util.List;

import net.opentrends.carrental.model.Rent;

public interface RentDAOService {
	public List listAll();
	public Rent save(Rent rent);
	public void delete(Rent rent);
	public Rent findByKey(int id);

}
