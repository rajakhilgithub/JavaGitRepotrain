package net.opentrends.shoppingcart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.shoppingcart.dao.SellerDao;
import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.dto.SellerDto;

@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	SellerDao sellerDao;

	@Override
	@Transactional
	public SellerDto getById(int id) {
		// TODO Auto-generated method stub
		return this.sellerDao.getById(id);
	}

	@Override
	@Transactional
	public List<SellerDto> listAll() {
		// TODO Auto-generated method stub
		return this.sellerDao.listAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(RegistrationDto registerDto) {
		// TODO Auto-generated method stub
		 this.sellerDao.saveOrUpdate(registerDto);
	}

	@Override
	@Transactional
	public SellerDto getSellerByEmail(String email) {
		return this.sellerDao.getSellerByEmail(email);
	}

}
