package com.apirest.Registro_pqr.models.services;

import java.util.List;

import com.apirest.Registro_pqr.models.dao.GRolesDao;
import com.apirest.Registro_pqr.models.entity.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GRolesService {

	@Autowired
	private GRolesDao gRolesDao;

	public List<Roles> findAll() {
		return gRolesDao.findAll();
	}

	public Roles findById(Integer id) {
		return gRolesDao.findById(id).orElse(null);
	}

	public Roles create(Roles roles) {
		return gRolesDao.save(roles);
	}
}