package com.estudos.curso.entities;

import java.io.Serializable;
import java.util.Objects;

import com.estudos.curso.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Para configurar a classe com chave composta
	@EmbeddedId 
	private OrderItemPK id = new OrderItemPK(); // Contem as chaves de Product e Order, instancia para não inicar como nulo
	
	private Integer quantity;
	private Double price;

	public OrderItem() {
		
	}
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product); // Acesso ao OrderItem com valores que vierem de Order e Product.
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		
		id.setOrder(order);
	}
	
	//@JsonIgnore
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
	
	// Metodo com o uso do get pois é necessário para aparecer no json
	public Double getSubTotal() {	
		return price * quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
