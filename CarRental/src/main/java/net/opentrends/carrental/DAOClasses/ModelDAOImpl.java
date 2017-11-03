package net.opentrends.carrental.DAOClasses;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.carrental.DAOServices.BrandDAOService;
import net.opentrends.carrental.DTOClasses.ModelDTO;
import net.opentrends.carrental.model.Brand;
import net.opentrends.carrental.model.Model;
@Repository
public class ModelDAOImpl implements ModelDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	BrandDAOService brandService;
	@Override
	public List listAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Model.class);
		return crit.list();
	}

	@Override
	public Model save(Model model) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.save(model);
		return model;
	}

	@Override
	public void delete(Model model) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.delete(model);
	}

	@Override
	public Model findByKey(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		return session.get(Model.class,id);
	}

	@Override
	public Model findByName(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Model.class);
		crit.add(Restrictions.ilike("modelNo", name));
		return (Model) crit.uniqueResult();
	}

	@Override
	public List getModelListByBranchId(int brandId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Model.class);
		crit.createAlias("brand", "b");
		crit.add(Restrictions.eq("b.brandID", brandId));
		
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Model> query = builder.createQuery(Model.class);
//		Root<Model> modelroot = query.from(Model.class);
//		Root<Brand> brandroot = query.from(Brand.class);
//		query.multiselect(modelroot, brandroot);
//		query.where(builder.equal(modelroot.get("brand"), brandroot.get("brandID")));
//		Query<Model> query1=session.createQuery(query);
//		return query1.getResultList();
		List<Model> model= crit.list();
		List<ModelDTO> modelDto=new ArrayList<>();
		for(Model model_item:model) {
			ModelDTO modelDTO=new ModelDTO();
			BeanUtils.copyProperties(model_item, modelDTO);
			modelDto.add(modelDTO);
		}
		System.out.println("---"+modelDto.size());
		return modelDto;
	}

}
