package net.opentrends.shoppingcart.service;

import java.util.List;

import net.opentrends.shoppingcart.dto.OrdersDto;

public interface OrdersService {
	public List<OrdersDto> listByBuyerId(int id);

	public void saveOrUpdate(OrdersDto ordersDto);
}
