package com.adrieu.projeto004.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrieu.projeto004.entities.Product;
import com.adrieu.projeto004.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public ProductService() {
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
	
	

}
