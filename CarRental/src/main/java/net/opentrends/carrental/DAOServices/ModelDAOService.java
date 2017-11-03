package net.opentrends.carrental.DAOServices;

import java.util.List;

import net.opentrends.carrental.DTOClasses.ModelFormDTO;
import net.opentrends.carrental.model.Model;

public interface ModelDAOService {
	public List listAll();
	public Model save(Model model);
	public void delete(Model model);
	public Model findByKey(int id);
	public Model findByName(String name);
	public String addVehicle(ModelFormDTO modelDto);
	public List getModelListByBranchId(int id);
}
