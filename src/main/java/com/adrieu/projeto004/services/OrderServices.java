package com.adrieu.projeto004.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrieu.projeto004.entities.Order;
import com.adrieu.projeto004.repositories.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> finAll() {
		return orderRepository.findAll();
	}
	
	public Order findById (Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}

}
