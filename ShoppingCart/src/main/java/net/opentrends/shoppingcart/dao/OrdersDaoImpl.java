package net.opentrends.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.shoppingcart.dto.OrdersDto;
import net.opentrends.shoppingcart.model.Buyer;
import net.opentrends.shoppingcart.model.Orders;
import net.opentrends.shoppingcart.service.ProductService;

@Repository
public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductService productService;

	@Override
	public List<OrdersDto> listByBuyerId(int id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Orders.class);
		criteria.add(Restrictions.eq("buyer.buyerId", id));
		List<Orders> orderList = criteria.list();
		List<OrdersDto> ordersDtoList = new ArrayList<>();
		for (Orders orders : orderList) {
			OrdersDto ordersDto = new OrdersDto();
			BeanUtils.copyProperties(orders, ordersDto);
			ordersDto.setSellerName(productService.getProductByProductName(orders.getProductName()).getSellerName());
			ordersDto
					.setProductPrice(productService.getProductByProductName(orders.getProductName()).getProductPrice());
			ordersDtoList.add(ordersDto);
		}
		return ordersDtoList;
	}

	@Override
	public void saveOrUpdate(OrdersDto ordersDto) {
		Orders orders = new Orders();
		BeanUtils.copyProperties(ordersDto, orders);
		Buyer buyer = sessionFactory.openSession().get(Buyer.class, ordersDto.getBuyerId());
		orders.setBuyer(buyer);
		sessionFactory.openSession().saveOrUpdate(orders);
	}

}
