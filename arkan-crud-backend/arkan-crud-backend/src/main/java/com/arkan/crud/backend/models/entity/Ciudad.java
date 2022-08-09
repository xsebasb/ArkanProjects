package com.arkan.crud.backend.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="ciudad")
public class Ciudad implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El nombre no puede ser nulo")
	@Max(value = 50, message = "Nombre no debe ser mayor a 50")
	private String nombre_ciudad;
	
	@JsonBackReference
	@OneToMany(mappedBy = "ciudad")
	private List<Usuario> usuario;




	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Ciudad() {
		super();
	}

	public Ciudad(Long id, String nombre_ciudad) {
		super();
		this.id = id;
		this.nombre_ciudad = nombre_ciudad;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_ciudad() {
		return nombre_ciudad;
	}
	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}

	private static final long serialVersionUID = 1L;
}

