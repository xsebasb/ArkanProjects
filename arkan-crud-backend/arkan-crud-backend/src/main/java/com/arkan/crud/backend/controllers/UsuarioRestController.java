package com.arkan.crud.backend.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.arkan.crud.backend.models.entity.Usuario;
import com.arkan.crud.backend.models.services.IUsuarioService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioService;


	@GetMapping("/usuarios")
	public List<Usuario> index() {
		List<Usuario> usuarios = this.usuarioService.findAll();
		return usuarios;
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario show(@PathVariable Long id) {
		return this.usuarioService.findById(id);
	}
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		this.usuarioService.save(usuario);
		return usuario;
	}
	
	@PutMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario currentCliente = this.usuarioService.findById(id);
		currentCliente.setNombre(usuario.getNombre());
		currentCliente.setApellido(usuario.getApellido());
		currentCliente.setEmail(usuario.getEmail());
		this.usuarioService.save(currentCliente);
		return currentCliente;
	}
	
	@DeleteMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Usuario currentUsuario = this.usuarioService.findById(id);
		this.usuarioService.delete(currentUsuario);
	}

	}
