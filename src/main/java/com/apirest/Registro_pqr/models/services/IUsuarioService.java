package com.apirest.Registro_pqr.models.services;

import com.apirest.Registro_pqr.models.entity.Usuarios;

public interface IUsuarioService {
  public Usuarios findByUsername(String username);
}
