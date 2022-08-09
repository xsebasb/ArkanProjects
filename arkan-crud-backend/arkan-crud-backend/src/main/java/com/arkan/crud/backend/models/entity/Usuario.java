package com.arkan.crud.backend.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "La ciudad no puede ser nula")
	@OneToOne()
	@JoinColumn(name = "id_ciudad")
	private Ciudad ciudad;
	
	@NotNull(message = "El nombre no puede ser nulo")
	@Max(value = 50, message = "Nombre no debe ser mayor a 50")
	private String nombre;
	
	@NotNull(message = "El Apellido no puede ser nulo")
	@Max(value = 50, message = "Apellido no debe ser mayor a 50")
	private String apellido;
	
	@NotNull(message = "El email no puede ser nulo")
	@Max(value = 150, message = "Email no debe ser mayor a 150")
	@Email(message = "Email debe ser valido")
	private String email;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private static final long serialVersionUID = 1L;
}
