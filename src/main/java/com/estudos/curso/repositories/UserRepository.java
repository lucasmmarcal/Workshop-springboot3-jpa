package com.estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.curso.entities.User;

/* Apesar de ser uma interface, a entidade User não tem metodos a implementar, pois a classe JpaRepository já possui os métodos
   para manipulação do BD, como saveAll, save, delete etc.
*/
public interface UserRepository extends JpaRepository<User, Long> {
	 
}
