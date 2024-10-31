package com.estudos.curso.entities.pk;

import java.io.Serializable;

import com.estudos.curso.entities.Order;
import com.estudos.curso.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
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

}
