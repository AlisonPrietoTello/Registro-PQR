package com.apirest.Registro_pqr.models.entity;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuarios.class)
public abstract class Usuarios_ {

	public static volatile SingularAttribute<Usuarios, String> password;
	public static volatile SingularAttribute<Usuarios, BigInteger> idempresa;
	public static volatile SingularAttribute<Usuarios, String> apellido;
	public static volatile ListAttribute<Usuarios, Roles> roles;
	public static volatile SingularAttribute<Usuarios, String> documento;
	public static volatile SingularAttribute<Usuarios, Long> id;
	public static volatile SingularAttribute<Usuarios, String> nombre;
	public static volatile SingularAttribute<Usuarios, String> email;
	public static volatile SingularAttribute<Usuarios, Boolean> enabled;
	public static volatile SingularAttribute<Usuarios, String> username;

	public static final String PASSWORD = "password";
	public static final String IDEMPRESA = "idempresa";
	public static final String APELLIDO = "apellido";
	public static final String ROLES = "roles";
	public static final String DOCUMENTO = "documento";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String EMAIL = "email";
	public static final String ENABLED = "enabled";
	public static final String USERNAME = "username";

}

