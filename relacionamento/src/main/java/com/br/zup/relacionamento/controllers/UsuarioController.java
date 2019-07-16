package com.br.zup.relacionamento.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.zup.relacionamento.models.Login;
import com.br.zup.relacionamento.models.Usuario;
import com.br.zup.relacionamento.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastrar")
	public ModelAndView salvarUsuario () {
		ModelAndView modelAndView = new ModelAndView("cadastro.html");
		modelAndView.addObject("usuarios", usuarioService.usuarios());
		return modelAndView;
	}
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarUsuario (@Valid Usuario user, BindingResult bindingUser, @Valid Login senha, BindingResult bindingLogin) {
		ModelAndView modelAndView = new ModelAndView("cadastro.html");
		
	if (bindingUser.hasErrors() || bindingLogin.hasErrors()) {
		List<String> erros = new ArrayList<String>();
		for (ObjectError objectError : bindingUser.getAllErrors()) {
			erros.add(objectError.getDefaultMessage());
			
		}
		for (ObjectError objectError : bindingLogin.getAllErrors()) {
			erros.add(objectError.getDefaultMessage());
		}
		modelAndView.addObject("usuarios", usuarioService.usuarios());
		modelAndView.addObject("erros", erros);
		return modelAndView;
		
	}else {
		usuarioService.criarUser(user,senha);
		modelAndView.addObject("usuarios", usuarioService.usuarios());
		return modelAndView;
		}
		
	}
	
}
