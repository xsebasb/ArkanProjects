package com.arkan.crud.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arkan.crud.backend.models.entity.Usuario;
import com.arkan.crud.backend.models.services.IUsuarioService;



@RestController
@RequestMapping("/api/v1")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioService;

	/**Method Get**/
	@GetMapping("/usuarios")
	public List<Usuario> index() {
		List<Usuario> usuarios = this.usuarioService.findAll();
		return usuarios;
	}

	}
