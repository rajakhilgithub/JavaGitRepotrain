package net.opentrends.shoppingcart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.shoppingcart.dao.OrdersDao;
import net.opentrends.shoppingcart.dto.OrdersDto;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDao ordersDao;

	@Override
	@Transactional
	public List<OrdersDto> listByBuyerId(int id) {
		return this.ordersDao.listByBuyerId(id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(OrdersDto ordersDto) {
		this.ordersDao.saveOrUpdate(ordersDto);
	}

}
