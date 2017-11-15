package net.opentrends.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.dto.SellerDto;
import net.opentrends.shoppingcart.model.Seller;

@Repository
public class SellerDaoImpl implements SellerDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public SellerDto getById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Seller seller = session.get(Seller.class, id);
		SellerDto sellerDto = new SellerDto();
		BeanUtils.copyProperties(seller, sellerDto);
		return sellerDto;
	}

	@Override
	public List<SellerDto> listAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Seller.class);
		List<Seller> sellerList = criteria.list();
		List<SellerDto> sellerDtoList = new ArrayList<>();
		for (Seller seller1 : sellerList) {
			SellerDto sellerDto1 = new SellerDto();
			BeanUtils.copyProperties(seller1, sellerDto1);
			sellerDtoList.add(sellerDto1);
		}

		return sellerDtoList;
	}

	@Override
	public void saveOrUpdate(RegistrationDto registerDto) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Seller seller = new Seller();
		BeanUtils.copyProperties(registerDto, seller);
		session.saveOrUpdate(seller);
	}

	@Override
	public SellerDto getSellerByEmail(String email) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Seller.class);
		criteria.add(Restrictions.eq("emailId", email));
		Seller seller = (Seller) criteria.uniqueResult();
		SellerDto sellerDto = new SellerDto();
		BeanUtils.copyProperties(seller, sellerDto);
		return sellerDto;
	}

}
