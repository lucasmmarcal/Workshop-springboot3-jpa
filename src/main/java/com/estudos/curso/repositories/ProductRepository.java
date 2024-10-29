package com.estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
