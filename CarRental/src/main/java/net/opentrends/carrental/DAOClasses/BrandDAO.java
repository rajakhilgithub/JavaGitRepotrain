package net.opentrends.carrental.DAOClasses;

import java.util.List;

import net.opentrends.carrental.model.Brand;

public interface BrandDAO {
public List listAll();
public Brand save(Brand brand);
public void delete(Brand brand);
public Brand findByKey(int id);
public Brand findByName(String name);
public List listNames();
}
