package net.opentrends.carrental.DAOServices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.carrental.DAOClasses.RentDAO;
import net.opentrends.carrental.model.Rent;

@Service
public class RentDAOServiceImpl implements RentDAOService {
@Autowired
RentDAO rentDao;
	@Override
	@Transactional
	public List listAll() {
		// TODO Auto-generated method stub
		return this.rentDao.listAll();
	}

	@Override
	@Transactional

	public Rent save(Rent rent) {
		// TODO Auto-generated method stub
		return this.rentDao.save(rent);
	}

	@Override
	@Transactional

	public void delete(Rent rent) {
		// TODO Auto-generated method stub
		this.rentDao.delete(rent);
	}

	@Override
	@Transactional

	public Rent findByKey(int id) {
		// TODO Auto-generated method stub
		return this.rentDao.findByKey(id);
	}

	

}
