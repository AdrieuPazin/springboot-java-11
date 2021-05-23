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

//Camada de Recursos que depende da camada de Serviçoes e a cama de Serviçoes dependem da cama de Repositories
//Usa a a anotation RestController
@RestController
//chamando o recurso user
@RequestMapping("/users")
public class UserResource {

	//Injeção de dependencias. Camada de Serviços injetada na cama de recursos
	@Autowired
	private UserServices userServive;
	
	//ResponseEntity, recurso Spring para retornar respostas de requisições web
	// GetMapping responde no metodo GET
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		
		List<Users> list = userServive.findAll();
		
		//retornar resposta com sucesso e o corpo da resposta
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id){
		
		Users u = userServive.findById(id);
		
		return ResponseEntity.ok().body(u);
		
	}
	
}
