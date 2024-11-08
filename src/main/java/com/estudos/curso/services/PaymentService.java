package com.estudos.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.curso.entities.Payment;
import com.estudos.curso.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository repository; 
	
	public List<Payment> FindAll(){
		
		return repository.findAll();
		
	}
	
	public Payment findById(Long id) {
		
		Optional<Payment> obj= repository.findById(id);
		return obj.get();
		
	}
}
