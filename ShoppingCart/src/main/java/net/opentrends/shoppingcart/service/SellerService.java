package net.opentrends.shoppingcart.service;

import java.util.List;

import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.dto.SellerDto;

public interface SellerService {
	public SellerDto getById(int id);

	public List<SellerDto> listAll();

	public void saveOrUpdate(RegistrationDto registerDto);

	public SellerDto getSellerByEmail(String email);
}
