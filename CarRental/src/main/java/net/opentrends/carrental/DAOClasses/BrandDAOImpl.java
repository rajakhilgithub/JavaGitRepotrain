package net.opentrends.carrental.DAOClasses;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import net.opentrends.carrental.model.Brand;
@Repository
public class BrandDAOImpl implements BrandDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List listAll() {
		Session session=sessionFactory.openSession();
		
		Query<?> query=(Query) session.createQuery("FROM Brand");
		return query.getResultList();
	}

	@Override
	public Brand save(Brand brand) {
		System.out.println("hai2");
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(brand);
		return brand;
	}

	@Override
	public void delete(Brand brand) {
		Session session=sessionFactory.openSession();
		session.delete(brand);
		
	}

	@Override
	public Brand findByKey(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Brand) session.get(Brand.class, id);
	}

	@Override
	public Brand findByName(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Brand.class);
		cr.add(Restrictions.ilike("name", name));
		return (Brand) cr.uniqueResult();
	}

	@Override
	public List listNames() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Brand.class);
		return  crit.list();
	}

}
