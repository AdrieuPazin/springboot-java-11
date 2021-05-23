package com.adrieu.projeto004.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrieu.projeto004.entities.Category;
import com.adrieu.projeto004.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;
	
	
	public CategoryResource() {
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> cat = categoryService.findAll();		
		return ResponseEntity.ok().body(cat);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){

		Category cat = categoryService.findById(id);		
		return ResponseEntity.ok().body(cat);
		
	}
	
	

}
