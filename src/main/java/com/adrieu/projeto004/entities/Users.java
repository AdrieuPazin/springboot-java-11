package com.adrieu.projeto004.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")
public class Users implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private String senha;
	
	//1-N
	//JsonIgnore no lado da relação que tiver essa annotation, significa que Users NÃO chamará os PEDIDOS relacionados. 
	//Se o JsonIgnore estiver em ORDER, ao chamar Users SERÁ chamado também os pedidos relacionados ao CLIENTE e se chamar os Pedidos (ORDER) não será chamado os clientes relacionados.
	//OneToMany precisa referenciar o nome do atributo onde está a chave estrangeira no lado N da relação muitos-para-um (cliente e não cliente_id. É o nome do ATRIBUTO)
	@JsonIgnore// Para não ficar em look, pedido chama cliente e cliente chama pedido, devido ao relacionamento ser "mão dupla"
	@OneToMany(mappedBy = "cliente")
	private List<Order> order = new ArrayList<>();
	
	public Users () {}

	public Users(Long id, String nome, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Order> getOrder() {
		return order;
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
		Users other = (Users) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
