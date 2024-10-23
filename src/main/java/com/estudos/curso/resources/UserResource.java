package com.estudos.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.curso.entities.User;

// @RestController para indicar que a classe é um recurso web implementado pela Controller Rest 
@RestController
@RequestMapping(value = "/Users")
public class UserResource {
	
	// ResponseEntity é um tipo no Spring para retornar respostas Web
	@GetMapping
	public ResponseEntity<User> findAll() {
		
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		//ResponseEntity.ok() retorna que a operação foi Ok.
		//body(u) retorna o corpo da mensagem, no caso a instanciação de u
		return ResponseEntity.ok().body(u);
		
	}

}
