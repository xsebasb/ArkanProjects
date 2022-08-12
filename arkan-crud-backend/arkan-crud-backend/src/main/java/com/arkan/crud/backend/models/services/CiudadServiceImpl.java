package com.arkan.crud.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arkan.crud.backend.models.dao.ICiudadDao;
import com.arkan.crud.backend.models.entity.Ciudad;


@Service
public class CiudadServiceImpl implements ICiudadService{

	@Autowired
	private ICiudadDao ciudadDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAll() {
		return (List<Ciudad>) ciudadDao.findAll();
	}

	@Override
	@Transactional
	public void save(Ciudad ciudad) {
		 ciudadDao.save(ciudad);
	}

	@Override
	public Ciudad findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Ciudad ciudad) {
		// TODO Auto-generated method stub
		
	}



}
