package com.estudos.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.estudos.curso.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus;
	
	// Relacionamento de Order com User é Muitos para um, ou seja, um user pode ter N orders
	@ManyToOne  
	// Criação da chave estrangeira na tabela User
	@JoinColumn(name = "client_id") 
	private User client;

	// id.order, em OrdemItem existe o id e o id que tem o Order, chave de OrderItemPk
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>(); // HashSet é uma lista que não permite valores iguais

	// Para a notação @OneToOne é necessário o mapeamento com Cascade, onde uma chave deve ser igual em Order e Payment
	@OneToOne(mappedBy = "order", cascade = jakarta.persistence.CascadeType.ALL)
	private Payment payment;
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus); // Pega o codigo na função valueOf no enum OrderStatus
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode(); // Pega o numero inteiro em OrderStatus e retorna no Integer de OrderStatus
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/* Na coleção Set(pode confundir, esse Set é uma função para não permitir duplicados), são retornados os items preenchidos
	   pela lista Set */
	public Set<OrderItem> getItems(){ 
		
		return items;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(OrderItem x: items) {
			sum += x.getSubTotal();
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		return "Order [Id=" + id + ", moment=" + moment + "]";
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}	
}
