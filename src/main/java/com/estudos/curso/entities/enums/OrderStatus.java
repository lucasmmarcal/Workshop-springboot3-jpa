package com.estudos.curso.entities.enums;

public enum OrderStatus {
	
	WAITING(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4), 
	CANCELED(5);
	
	private int code; // Para manipular os códigos dos enums
	
	private OrderStatus(int code) { // Construtor do tipo private
		this.code = code;
	}
	
	public int getCode() { // Metodo publico para acessar o construtor (private)
		return code;
	}
	
	// Metodo para transformar um código em um tipo enumerado
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) { // OrderStatus.values() pecorre todos os enums possíveis
			if(value.getCode() == code){
				return value;	
			}
		}
		throw new IllegalArgumentException("Codigo de OrderStatus Invalido");
	}
}
