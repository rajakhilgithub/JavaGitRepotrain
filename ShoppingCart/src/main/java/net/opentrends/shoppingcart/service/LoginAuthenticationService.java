package net.opentrends.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.shoppingcart.dto.BuyerDto;
import net.opentrends.shoppingcart.dto.Login;
import net.opentrends.shoppingcart.dto.RegistrationDto;
import net.opentrends.shoppingcart.dto.SellerDto;

@Service
public class LoginAuthenticationService {
	@Autowired
	SellerService sellerService;
	@Autowired
	BuyerService buyerService;

	public boolean authenticate(Login login) {
		List<SellerDto> sellerDtoList = sellerService.listAll();
		List<BuyerDto> buyerDtoList = buyerService.listAll();
		System.out.println(buyerDtoList.size());
		if (login.getType().equals("buyer")) {
			for (BuyerDto buyerDto : buyerDtoList) {
				System.out.println("email= " + login.getUsername());
				System.out.println("pasww= " + buyerDto.getPassword());
				if ((buyerDto.getEmailId().equals(login.getUsername()))
						&& (buyerDto.getPassword().equals(login.getPassWord()))) {
					return true;
				}
			}
		} else {
			for (SellerDto sellerDto : sellerDtoList) {
				if ((sellerDto.getPassword().equals(login.getPassWord()))
						&& (sellerDto.getEmailId().equals(login.getUsername()))) {
					return true;

				}
			}
		}
		return false;
	}
}
