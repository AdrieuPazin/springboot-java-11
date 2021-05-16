package com.adrieu.projeto004.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrieu.projeto004.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	
	
}
