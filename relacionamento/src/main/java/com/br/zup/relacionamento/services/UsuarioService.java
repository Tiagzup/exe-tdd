package com.br.zup.relacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.relacionamento.models.Login;
import com.br.zup.relacionamento.models.Usuario;
import com.br.zup.relacionamento.repositories.LoginRepository;
import com.br.zup.relacionamento.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	
	public String criarUser (Usuario usuario, Login login) {
		login.setUsuario(usuario);
		loginRepository.save(login);
		return "Usuario salvo";
	}
	public Iterable<Usuario> usuarios (){
		return usuarioRepository.findAll();
	}
}
