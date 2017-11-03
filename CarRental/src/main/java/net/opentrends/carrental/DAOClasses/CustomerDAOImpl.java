package net.opentrends.carrental.DAOClasses;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.carrental.model.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List listAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Customer.class);
		return crit.list();
	}

	@Override
	public void delete(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(customer);
		
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.save(customer);
		return customer;
	}

	@Override
	public Customer findByKey(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

}
