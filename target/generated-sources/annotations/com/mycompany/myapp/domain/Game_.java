package com.mycompany.myapp.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Game.class)
public abstract class Game_ {

	public static volatile SingularAttribute<Game, String> idAccount;
	public static volatile SingularAttribute<Game, String> categorie;
	public static volatile SingularAttribute<Game, String> level;
	public static volatile SingularAttribute<Game, String> name;
	public static volatile SingularAttribute<Game, Long> id;

	public static final String ID_ACCOUNT = "idAccount";
	public static final String CATEGORIE = "categorie";
	public static final String LEVEL = "level";
	public static final String NAME = "name";
	public static final String ID = "id";

}

