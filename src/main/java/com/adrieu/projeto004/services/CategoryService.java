package com.adrieu.projeto004.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.adrieu.projeto004.entities.Category;
import com.adrieu.projeto004.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categRepository;
	
	
	public CategoryService() {
	}
	
	public List<Category> findAll(){
		return categRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = categRepository.findById(id);
		return obj.get();
		
		
	}
	
}
