package com.arkan.crud.backend.models.dao;


import org.springframework.data.repository.CrudRepository;
import com.arkan.crud.backend.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	


}
