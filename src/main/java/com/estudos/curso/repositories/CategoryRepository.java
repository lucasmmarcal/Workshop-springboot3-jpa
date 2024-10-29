package com.estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
