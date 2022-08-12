package com.arkan.crud.backend.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.arkan.crud.backend.models.entity.Ciudad;
import com.arkan.crud.backend.models.services.ICiudadService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class CiudadRestController {
	@Autowired
	private ICiudadService ciudadService;


	@GetMapping("/ciudades")
	public List<Ciudad> index() {
		List<Ciudad> ciudades = this.ciudadService.findAll();
		return ciudades;
	}
	
	@PostMapping("/ciudades")
	@ResponseStatus(HttpStatus.CREATED)
	public Ciudad create(@RequestBody Ciudad ciudad) {
		this.ciudadService.save(ciudad);
		return ciudad;
	}

	}
