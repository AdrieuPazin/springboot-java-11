package com.adrieu.projeto004.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrieu.projeto004.entities.Category;

//Criando o repository de Category, herdando do JpaRepository com vários operacoes de crud para a categoria
public interface CategoryRepository extends JpaRepository<Category, Long>{

	
	
}
