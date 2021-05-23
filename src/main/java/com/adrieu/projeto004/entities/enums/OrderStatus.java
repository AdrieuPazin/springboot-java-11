package com.adrieu.projeto004.entities.enums;

public enum OrderStatus {
	//definindo valores int padrão nos enums
	WAITING_PAYYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	//no java é necessario implementar o construtor abaixo no PRIVADO caso defina o valor manualmente dos enums
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// metodo publico para acessar os valores int dos enums
	public int getCode() {
		return code;
	}
	
	// metodo estatico para não instanciar
	public static OrderStatus valueOf(int code) {
		// PERCORRENDO OS VALORES POSSIVEIS DO ORDERSTATUS. Se correspónder ao código retorna o código
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}			
		}
		//Caso seja informado um código que não existe
		throw new IllegalArgumentException("Erro de código do OrderStatus");
	}
	

}
