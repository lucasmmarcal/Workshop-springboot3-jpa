package com.estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
