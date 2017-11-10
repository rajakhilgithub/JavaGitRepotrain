package net.opentrends.shoppingcart.dao;

import java.util.List;

import net.opentrends.shoppingcart.dto.OrdersDto;

public interface OrdersDao {

	public List<OrdersDto> listByBuyerId(int id);

	public void saveOrUpdate(OrdersDto ordersDto);

}
