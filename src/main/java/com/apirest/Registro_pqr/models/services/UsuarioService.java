package com.apirest.Registro_pqr.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.Registro_pqr.models.dao.IRoleDao;
import com.apirest.Registro_pqr.models.dao.IUsuarioDao;
import com.apirest.Registro_pqr.models.entity.Roles;
import com.apirest.Registro_pqr.models.entity.Usuarios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.Arrays;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            logger.error("Error en el Login: no existe el usuario '" + username + "' En el Sistema!");
            throw new UsernameNotFoundException(
                    "Error en el Login: no existe el usuario '" + username + "' En el Sistema!");
        }

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> logger.info("Role :" + authority.getAuthority())).collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true,
                authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    public List<Usuarios> findAllUsers() {
        return usuarioDao.findAllUsers();
    }

    public List<Usuarios> findByIdEntidad(Integer idEntidad) {
        return usuarioDao.findByIdEntidad(idEntidad);
    }

    public Usuarios crearNuevoUsuario(Usuarios usuario) {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Usuarios userNew = new Usuarios();

        userNew.setApellido(usuario.getApellido());
        userNew.setDocumento(usuario.getDocumento());
        userNew.setEmail(usuario.getEmail());
        userNew.setEnabled(usuario.isEnabled());
        userNew.setNombre(usuario.getNombre());
        userNew.setUsername(usuario.getUsername());
        userNew.setPassword(passwordEncoder().encode(usuario.getPassword()));

        Roles userRole = roleDao.findByNombre("ROLE_ADMIN");

        userNew.setRoles(Arrays.asList(userRole));

        String json;
        try {
            json = ow.writeValueAsString(userNew);
            logger.info("usuario creado: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return usuarioDao.save(userNew);
    }
}
