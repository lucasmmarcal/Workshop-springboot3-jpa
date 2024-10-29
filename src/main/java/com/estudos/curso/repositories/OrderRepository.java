package com.estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
