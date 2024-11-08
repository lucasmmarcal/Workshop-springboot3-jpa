package com.estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.curso.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
}
