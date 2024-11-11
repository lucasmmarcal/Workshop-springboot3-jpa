package com.estudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudos.curso.entities.User;
import com.estudos.curso.repositories.UserRepository;
import com.estudos.curso.services.exceptions.DatabaseException;
import com.estudos.curso.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		// Lançando o excessão do erro manualmente 
		return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
	}
	
	public User insert(User obj) {
		
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		
		try {
			// Preparar o id para ser atualizado com a função getReferenceById(id)
			User entity = userRepository.getReferenceById(id);
			updateData(obj,entity);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
		
	}
}
