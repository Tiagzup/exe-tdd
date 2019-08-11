package com.br.zup.relacionamento.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UsuarioTest {
	private Usuario usuario;
	@Before
	public void prepare () {
		usuario = new Usuario ();
		usuario.setId(null);
		usuario.setNome("Luci");
		usuario.setSobrenome("fer");
		usuario.setEmail("luci@fer.com");
		usuario.setLogin(null);
	}
	@Test
	public void testusuario () {
		assertEquals(usuario.getNome(), "Luci");
	}
	
}
