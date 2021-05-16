package com.adrieu.projeto004.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrieu.projeto004.entities.Users;
import com.adrieu.projeto004.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserServices userServive;
	
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		
		List<Users> list = userServive.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id){
		
		Users u = userServive.findById(id);
		
		return ResponseEntity.ok().body(u);
		
	}
	
}
