package com.adrieu.projeto004.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrieu.projeto004.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
	
}
