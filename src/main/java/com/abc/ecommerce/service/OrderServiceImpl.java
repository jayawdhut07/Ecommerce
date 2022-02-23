package com.abc.ecommerce.service;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecommerce.entity.Producttb;
import com.abc.ecommerce.entity.Order;
import com.abc.ecommerce.exception.ProductNotFoundException;
import com.abc.ecommerce.exception.ResourceNotFoundException;
import com.abc.ecommerce.repository.OrderRepository;
import com.abc.ecommerce.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Order saveOrder(Order order) {
		
		order.setOrderDate(LocalDate.now());
		
		int productId = order.getProductId();
		Optional<Producttb> optinalProduct = productRepository.findById(productId);
		
		if(optinalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not existing with id:" +productId);
		}
		
		else {
			Producttb product = optinalProduct.get();
			double totalPrice = product.getPrice();
			float orderPrice = (float) (order.getQuantity() * totalPrice);
			order.setOrderAmount(orderPrice);
		}
		
		Order newOrder = orderRepository.save(order);
		return newOrder;
		
	}

	@Override
	public Order getOrderDetails(int orderId) {
		
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found with order id:" +orderId);
		}
		
		return optionalOrder.get();
	}
}
