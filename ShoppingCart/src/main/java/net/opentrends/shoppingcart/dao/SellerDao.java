package net.opentrends.shoppingcart.dao;

import java.util.List;

import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.dto.SellerDto;

public interface SellerDao {
	public SellerDto getById(int id);

	public List<SellerDto> listAll();

	public void saveOrUpdate(RegistrationDto registerDto);

	public SellerDto getSellerByEmail(String email);

}
