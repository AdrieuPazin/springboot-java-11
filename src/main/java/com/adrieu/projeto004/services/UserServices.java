package com.adrieu.projeto004.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrieu.projeto004.entities.Users;
import com.adrieu.projeto004.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<Users> findAll(){
		return userRepository.findAll();
	}
	
	public Users findById(Long Id) {
		Optional<Users> obj = userRepository.findById(Id);
		return obj.get();
	}
}
