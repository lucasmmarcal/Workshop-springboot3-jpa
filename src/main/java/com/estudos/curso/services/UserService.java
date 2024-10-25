package com.estudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.curso.entities.User;
import com.estudos.curso.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 

	// Exterior todos os dados de User
	
	public List<User> findAll(){
		
	 	return userRepository.findAll();
		
	}
	
	public User FindById(Long Id) {
		
		// Optional usado pois o resultado pode ser nulo caso o ID não seja encontrado, gerando o resultado do erro
		Optional<User> obj = userRepository.findById(Id);	  
		return obj.get();
		
	}
	
}