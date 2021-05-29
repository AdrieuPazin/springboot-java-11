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
	// delete usuario
	public void delete(Long id)	{
		userRepository.deleteById(id);
	}	
	
	//atualizar usuario	
	public Users update(Long id, Users obj) {
		//prepara objeto monitorado para ser alterado e depois fazer operação no banco de dados. É mais eficiente que o findByid
		Users entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		
	}

	private void updateData(Users entity, Users obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}
