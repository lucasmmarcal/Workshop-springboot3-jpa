package com.estudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.curso.entities.Category;
import com.estudos.curso.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository; 
	
	public List<Category> FindAll(){
		
		return repository.findAll();
		
	}
	
	public Category findById(Long id) {
		
		Optional<Category> obj= repository.findById(id);
		return obj.get();
		
	}
}
