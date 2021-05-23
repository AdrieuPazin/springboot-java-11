package com.adrieu.projeto004.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrieu.projeto004.entities.Users;

//Criando o repository de User, herdando do JpaRepository com vários operacoes de crud para o usuario
public interface UserRepository extends JpaRepository<Users, Long>{

	
	
}
