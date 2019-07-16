package com.br.zup.relacionamento.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity 
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O campo nome não pode ficar em branco")
	@Size(min = 2, message = "O nome precisa conter no mínimo duas 2 letras")
	private String nome;
	@NotBlank (message = "O campo sobrenome nao pode ficar em branco")
	@Size (min = 2, message = " O campo sobrenome precisa conter no mínimo 2 letras")
	private String sobrenome;
	@NotBlank(message = "O campo email não pode ficar em branco")
	@Email(message = "E-mail inválido")
	private String email;
	
	//Relacionamento
	@OneToOne(mappedBy = "usuario")
	
	private Login login;

	public Usuario() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
