package net.opentrends.shoppingcart.service;

import java.util.List;

import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.RegistrationDto;

public interface BuyerService {
	public void saveOrUpdate(RegistrationDto registerDto);

	public BuyerDto findById(int id);

	public List<BuyerDto> listAll();

	public BuyerDto getBuyerByEmail(String email);

}
