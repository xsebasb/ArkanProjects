package com.sistema.blog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ComentarioDTO {

	private long id;
	
	@NotEmpty(message = "El nombre no debe ser vacio o nulo")
	private String nombre;

	@NotEmpty
	@Size(min = 10,message = "El cuerpo del comentario debe tener al menos 10 caracteres")
	private String cuerpo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public ComentarioDTO() {
		super();
	}

}
