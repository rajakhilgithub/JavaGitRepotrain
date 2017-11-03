package net.opentrends.carrental.DAOClasses;

import java.util.List;

import net.opentrends.carrental.model.Rent;

public interface RentDAO {
	public List listAll();
	public Rent save(Rent rent);
	public void delete(Rent rent);
	public Rent findByKey(int id);
	
}
