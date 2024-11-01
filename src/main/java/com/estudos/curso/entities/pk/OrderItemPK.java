package com.estudos.curso.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.estudos.curso.entities.Order;
import com.estudos.curso.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne;

// Essa classe é auxiliar para ligar o product a order 
// Essa classe não necessita de Construtor, pois ela será manipulada por product e order

@Embeddable // Notação para chave composta
public class OrderItemPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id") // Nome da chave estrangeira de Order na tabela OrderItem
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id") // Nome da chave estrangeira Product na tabela OrderItem
	private Product product;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	

}
