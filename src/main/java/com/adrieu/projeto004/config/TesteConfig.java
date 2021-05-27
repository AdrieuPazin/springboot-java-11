package com.adrieu.projeto004.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.adrieu.projeto004.entities.Category;
import com.adrieu.projeto004.entities.Order;
import com.adrieu.projeto004.entities.OrderItem;
import com.adrieu.projeto004.entities.Payment;
import com.adrieu.projeto004.entities.Product;
import com.adrieu.projeto004.entities.Users;
import com.adrieu.projeto004.entities.enums.OrderStatus;
import com.adrieu.projeto004.repositories.CategoryRepository;
import com.adrieu.projeto004.repositories.OrderItemRepository;
import com.adrieu.projeto004.repositories.OrderRepository;
import com.adrieu.projeto004.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	

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
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		
		//Salvando no H2, salvando uma lista de objetos
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
		//relacionando objeto produto com categoria
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);		
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		// salvando as associações entre objetos feitas anteriormente
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPreco()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPreco()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPreco()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPreco());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		//instacio a classe pagamento e passo-o como paramentro do objeto pedido da classe dominando que é Order para salvar no bd. Payment não precisa de repository
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
		
		
	}
	
	

}
