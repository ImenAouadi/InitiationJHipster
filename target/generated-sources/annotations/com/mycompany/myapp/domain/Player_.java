package com.mycompany.myapp.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Player.class)
public abstract class Player_ {

	public static volatile SingularAttribute<Player, Integer> score;
	public static volatile SingularAttribute<Player, String> idAccount;
	public static volatile SetAttribute<Player, Team> teams;
	public static volatile SingularAttribute<Player, Long> id;
	public static volatile SingularAttribute<Player, String> avatar;

	public static final String SCORE = "score";
	public static final String ID_ACCOUNT = "idAccount";
	public static final String TEAMS = "teams";
	public static final String ID = "id";
	public static final String AVATAR = "avatar";

}

