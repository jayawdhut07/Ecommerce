package com.abc.ecommerce.service;

import com.abc.ecommerce.entity.Order;

public interface OrderService {
	
	public Order saveOrder(Order order);
	
	public Order getOrderDetails(int orderId);

}
