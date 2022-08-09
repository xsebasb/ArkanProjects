package com.arkan.crud.backend.models.services;

import com.arkan.crud.backend.models.entity.Usuario;
import java.util.List;


public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Usuario usuario);
	

}
