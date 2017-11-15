package net.opentrends.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.RegistrationDto;

import net.opentrends.shoppingcart.model.Buyer;

@Repository
public class BuyerDaoImpl implements BuyerDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(RegistrationDto registerDto) {
		Buyer buyer = new Buyer();
		BeanUtils.copyProperties(registerDto, buyer);
		sessionFactory.openSession().saveOrUpdate(buyer);
		
	}

	@Override
	public BuyerDto findById(int id) {
		Buyer buyer = sessionFactory.openSession().get(Buyer.class, id);
		BuyerDto buyerdto = new BuyerDto();
		BeanUtils.copyProperties(buyer, buyerdto);
		return buyerdto;
	}

	@Override
	public List<BuyerDto> listAll() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Buyer.class);
		List<Buyer> buyerList = criteria.list();
		List<BuyerDto> buyerDtoList = new ArrayList<>();
		for (Buyer buyer1 : buyerList) {
			BuyerDto buyerDto1 = new BuyerDto();
			BeanUtils.copyProperties(buyer1, buyerDto1);
			buyerDtoList.add(buyerDto1);
		}
		return buyerDtoList;
	}

	@Override
	public BuyerDto getBuyerByEmail(String email) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Buyer.class);
		criteria.add(Restrictions.eq("emailId", email));
		Buyer buyer = (Buyer) criteria.uniqueResult();
		BuyerDto buyerDto = new BuyerDto();
		BeanUtils.copyProperties(buyer, buyerDto);
		return buyerDto;
	}

}
