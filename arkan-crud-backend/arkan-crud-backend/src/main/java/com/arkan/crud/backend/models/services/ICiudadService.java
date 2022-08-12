package com.arkan.crud.backend.models.services;

import com.arkan.crud.backend.models.entity.Ciudad;


import java.util.List;


public interface ICiudadService {
	
	public List<Ciudad> findAll();
	
	public void save(Ciudad ciudad);
	
	public Ciudad findById(Long id);
	
	public void delete(Ciudad usuario);
	

}
