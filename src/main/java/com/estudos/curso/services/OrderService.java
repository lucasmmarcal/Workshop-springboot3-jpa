package com.estudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.curso.entities.Order;
import com.estudos.curso.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository; 
	
	public List<Order> FindAll(){
		
		return repository.findAll();
		
	}
	
	public Order findById(Long id) {
		
		Optional<Order> obj= repository.findById(id);
		return obj.get();
		
	}
}
