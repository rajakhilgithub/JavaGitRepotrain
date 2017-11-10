package net.opentrends.shoppingcart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.shoppingcart.dao.BuyerDao;
import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.RegistrationDto;

@Service
public class BuyerServiceImpl implements BuyerService {
	@Autowired
	BuyerDao buyerDao;

	@Override
	@Transactional
	public void saveOrUpdate(RegistrationDto registerDto) {
		// TODO Auto-generated method stub
		this.buyerDao.saveOrUpdate(registerDto);
	}

	@Override
	@Transactional
	public BuyerDto findById(int id) {
		// TODO Auto-generated method stub
		return this.buyerDao.findById(id);
	}

	@Override
	@Transactional
	public List<BuyerDto> listAll() {
		// TODO Auto-generated method stub
		return this.buyerDao.listAll();
	}

	@Override
	@Transactional
	public BuyerDto getBuyerByEmail(String email) {
		return this.buyerDao.getBuyerByEmail(email);
	}

}
