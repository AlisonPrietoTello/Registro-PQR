package com.apirest.Registro_pqr.models.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pqr.class)
public abstract class Pqr_ {

	public static volatile SingularAttribute<Pqr, String> descripcion;
	public static volatile SingularAttribute<Pqr, Integer> estado;
	public static volatile SingularAttribute<Pqr, Integer> fkPqr;
	public static volatile SingularAttribute<Pqr, String> adjunto;
	public static volatile SingularAttribute<Pqr, Date> fechaLimite;
	public static volatile SingularAttribute<Pqr, String> asunto;
	public static volatile SingularAttribute<Pqr, Date> fechaCreacion;
	public static volatile SingularAttribute<Pqr, Integer> usuario;
	public static volatile SingularAttribute<Pqr, Integer> id;

	public static final String DESCRIPCION = "descripcion";
	public static final String ESTADO = "estado";
	public static final String FK_PQR = "fkPqr";
	public static final String ADJUNTO = "adjunto";
	public static final String FECHA_LIMITE = "fechaLimite";
	public static final String ASUNTO = "asunto";
	public static final String FECHA_CREACION = "fechaCreacion";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";

}

