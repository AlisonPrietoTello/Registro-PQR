package com.apirest.Registro_pqr.models.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.apirest.Registro_pqr.models.entity.Usuarios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioDao extends CrudRepository<Usuarios, Long> {

    public Usuarios findByUsername(String username);

    @Query("select u from Usuarios u")
    public List<Usuarios> findAllUsers();

    @Query(value = "select * from usuarios where fk_ma_entidad=:idEntidad", nativeQuery = true)
    public List<Usuarios> findByIdEntidad(@Param("idEntidad") Integer idEntidad);
}
