package com.adrieu.projeto004.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrieu.projeto004.entities.Users;
import com.adrieu.projeto004.repositories.UserRepository;

//Camada de Serviços
@Service
public class UserServices {

	//Injeção de dependencias
	@Autowired
	private UserRepository userRepository;
	
	
	public List<Users> findAll(){
		return userRepository.findAll();
	}
	
	public Users findById(Long Id) {
		//Optional existe a partir do java 8
		Optional<Users> obj = userRepository.findById(Id);
		return obj.get();
	}
	
	// salvar usuario
	public Users insert(Users obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id)	{
		userRepository.deleteById(id);
	}	
}
