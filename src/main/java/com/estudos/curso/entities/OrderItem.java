package com.estudos.curso.entities;

import com.estudos.curso.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
private static final long serialVersionUID = 1L;
	
	@EmbeddedId // Para configurar a classe com chave composta
	private OrderItemPK id = new OrderItemPK(); // Contem as chaves de Product e Order
	
	private Integer quantity;
			
	private Double price;

	public OrderItem() {
		
	}
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setProduct(product); // Acesso ao OrderItem com valores que vierem de Order e Product.
		id.setOrder(order);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		
		id.setOrder(order);
	}
	
	@JsonIgnore
	public Order getProduct() {
		
		return id.getOrder();
	}
	
	public void setProduct(Product product) {
		
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}	
	
}
