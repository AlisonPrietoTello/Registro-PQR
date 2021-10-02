package com.apirest.Registro_pqr.models.dao;

import java.util.Optional;

import com.apirest.Registro_pqr.models.entity.Roles;

import org.springframework.data.repository.CrudRepository;

public interface IRoleDao extends CrudRepository<Roles, Long> {

    public Roles findByNombre(String nombre);

    public Optional<Roles> findById(Long id);
}
