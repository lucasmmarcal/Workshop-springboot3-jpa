package com.estudos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.curso.entities.OrderItem;
import com.estudos.curso.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
}
