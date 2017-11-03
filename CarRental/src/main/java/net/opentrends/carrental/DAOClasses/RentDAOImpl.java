package net.opentrends.carrental.DAOClasses;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.carrental.model.Model;
import net.opentrends.carrental.model.Rent;

@Repository
public class RentDAOImpl implements RentDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List listAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Rent.class);
		return cr.list();
	}

	@Override
	public Rent save(Rent rent) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.save(rent);
		return rent;
	}

	@Override
	public void delete(Rent rent) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.delete(rent);
	}

	@Override
	public Rent findByKey(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		return session.get(Rent.class,id);
	}



}
