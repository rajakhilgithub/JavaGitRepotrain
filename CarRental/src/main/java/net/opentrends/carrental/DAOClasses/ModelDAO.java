package net.opentrends.carrental.DAOClasses;

import java.util.List;

import net.opentrends.carrental.model.Brand;
import net.opentrends.carrental.model.Model;

public interface ModelDAO {
	public List listAll();
	public Model save(Model model);
	public void delete(Model model);
	public Model findByKey(int id);
	public Model findByName(String name);
	public List getModelListByBranchId(int brandId);
}
