package com.estudos.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estudos.curso.services.UserService;

import com.estudos.curso.entities.User;

// @RestController para indicar que a classe é um recurso web implementado pela Controller Rest 
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	// ResponseEntity é um tipo no Spring para retornar respostas Web
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = service.findAll();
		
		//ResponseEntity.ok() retorna que a operação foi Ok.
		//body(u) retorna o corpo da mensagem em json 
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){ // Notação @PathVariable  para indicar que o value no getMapping é o que será recebido como parâmetro
		
		User getUserById = service.FindById(id);
		return ResponseEntity.ok().body(getUserById);
	}

}
