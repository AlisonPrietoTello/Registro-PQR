package com.apirest.Registro_pqr.auth;

import java.util.HashMap;
import java.util.Map;

import com.apirest.Registro_pqr.models.entity.Usuarios;
import com.apirest.Registro_pqr.models.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

  @Autowired
  private IUsuarioService usuarioService;

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

    Usuarios usuario = usuarioService.findByUsername(authentication.getName());

    Map<String, Object> info = new HashMap<>();
    info.put("nombre", usuario.getNombre());
    info.put("apellido", usuario.getApellido());
    info.put("email", usuario.getEmail());
    info.put("enabled", usuario.isEnabled());
    info.put("id", usuario.getId());
    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
    return accessToken;
  }

}
