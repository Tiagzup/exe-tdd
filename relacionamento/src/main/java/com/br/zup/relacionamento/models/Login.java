package com.br.zup.relacionamento.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "O campo apelido não pode ficar em branco")
	@Size(min = 2, message = "O campo apelido precisa conter no mínimo 2 letras")
	private String apelido;
	@NotBlank(message = "O campo senha não pode ficar em branco")
	@Size(min = 8, message = "O campo senha precisa ter no mínino oito caracteres")
	private String senha;
	
	//Relacionameto
	@OneToOne(cascade = {CascadeType.ALL})
	private Usuario usuario;
	
	
	public Login() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	
}
