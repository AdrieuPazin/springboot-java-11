package com.adrieu.projeto004.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrieu.projeto004.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
