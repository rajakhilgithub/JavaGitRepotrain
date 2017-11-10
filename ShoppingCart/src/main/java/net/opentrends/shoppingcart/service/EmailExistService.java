package net.opentrends.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.dto.SellerDto;

@Service
public class EmailExistService {
	@Autowired
	BuyerService buyerService;
	@Autowired
	SellerService sellerService;

	public boolean findExists(RegistrationDto registerDto) {
		if (registerDto.getType().equals("seller")) {
			System.out.println("seller");
			List<SellerDto> sellerDtoList = sellerService.listAll();
			for (SellerDto sellerDto : sellerDtoList) {
				if (sellerDto.getEmailId().equals(registerDto.getEmailId())) {
					return true;
				}
			}
		} else {
			List<BuyerDto> buyerDtoList = buyerService.listAll();
			for (BuyerDto buyerDto : buyerDtoList) {
				if (buyerDto.getEmailId().equals(registerDto.getEmailId())) {
					return true;

				}
			}
		}
		return false;
	}
}
