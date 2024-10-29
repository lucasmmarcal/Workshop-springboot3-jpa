package com.estudos.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudos.curso.entities.Order;
import com.estudos.curso.entities.User;
import com.estudos.curso.entities.enums.OrderStatus;
import com.estudos.curso.repositories.OrderRepository;
import com.estudos.curso.repositories.UserRepository;

@Configuration // Informa ao spring que a classe é especifica de configuração
@Profile("test") // Esse nome foi definido no arquivo application.properties
public class TesteConfig implements CommandLineRunner {

	@Autowired // Para fazer a injeção de dependencia automaticamente
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override // Tudo que for colocado nesse metodo será iniciado ao executar a aplicação
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING , u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING , u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // Transforma objetos em Array
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

	
	
	
}
