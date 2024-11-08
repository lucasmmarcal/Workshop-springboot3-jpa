package com.estudos.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.curso.entities.Payment;
import com.estudos.curso.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	PaymentService service;	
	
	@GetMapping
	public ResponseEntity<List<Payment>> FindAll() {
		
		List<Payment> list = service.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id){
		
		Payment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
