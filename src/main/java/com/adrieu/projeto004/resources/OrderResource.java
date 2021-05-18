package com.adrieu.projeto004.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrieu.projeto004.entities.Order;
import com.adrieu.projeto004.services.OrderServices;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderServices orderServices;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> order = orderServices.finAll();
		return ResponseEntity.ok().body(order);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Order> findById(@PathVariable Long id){
		Order order = orderServices.findById(id);
		return ResponseEntity.ok().body(order);
	}

}
