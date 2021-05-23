package com.adrieu.projeto004.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.adrieu.projeto004.entities.Category;
import com.adrieu.projeto004.entities.Order;
import com.adrieu.projeto004.entities.Users;
import com.adrieu.projeto004.entities.enums.OrderStatus;
import com.adrieu.projeto004.repositories.CategoryRepository;
import com.adrieu.projeto004.repositories.OrderRepository;
import com.adrieu.projeto004.repositories.UserRepository;

//Criando arquivo de configurações para teste. Usa a anotation Configuration. Classe auxiliar de configuração
@Configuration
//nome test pois é o nome do banco dados H2 definido em application.properties
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	//Injeção de pedencias 
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Realizando o data Seeding. Executando quando o programa foi iniciando através da interface CommandLineRunner definido no inicio da classe
	@Override
	public void run(String... args) throws Exception {
		Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYYMENT, u1);
				
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		//Salvando no H2, salvando uma lista de objetos
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
	
	

}
