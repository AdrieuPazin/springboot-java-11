package com.adrieu.projeto004.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adrieu.projeto004.entities.Users;
import com.adrieu.projeto004.repositories.UserRepository;
import com.adrieu.projeto004.services.exceptions.DatabaseException;
import com.adrieu.projeto004.services.exceptions.ResourceNotFoundException;

//Camada de Serviços
@Service
public class UserServices {

	//Injeção de dependencias
	@Autowired
	private UserRepository userRepository;
	
	
	public List<Users> findAll(){
		return userRepository.findAll();
	}
	
	public Users findById(Long id) {
		//Optional existe a partir do java 8
		Optional<Users> obj = userRepository.findById(id);
		//tenta buscar o id, senão existir chama a classe de exceção personalizada
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// salvar usuario
	public Users insert(Users obj) {
		return userRepository.save(obj);
	}
	// delete usuario
	public void delete(Long id)	{
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
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
