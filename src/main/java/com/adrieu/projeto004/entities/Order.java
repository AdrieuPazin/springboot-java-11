package com.adrieu.projeto004.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.adrieu.projeto004.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento; 
	
	//valor Integer para deixar explicito que está gravando um numero interiro, mas isso somente dentro da classe ORDER
	private Integer orderStatus;
	
	//N-1
	//Atraves do JoinCOlumn é preciso definir o nome da chave estrangeeira do usuário (cliente_id)
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Users cliente;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	public Order() {}

	public Order(Long id, Instant momento, OrderStatus orderStatus, Users cliente) {
		super();
		this.id = id;
		this.momento = momento;
		//chamando o método de conversão de OrderStatus->Integer
		setOrderStatus(orderStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Instant getMomento() {
		return momento;
	}
	
	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	
	//Convertendo INTEGER para OrderStatus
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	//Convertendo Orderstatus para Integer
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();	
		}
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Users getCliente() {
		return cliente;
	}

	public void setCliente(Users cliente) {
		this.cliente = cliente;
	}

	public Set<OrderItem> getItems() {
		return items;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
		

}
