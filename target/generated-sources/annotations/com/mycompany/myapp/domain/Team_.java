package com.mycompany.myapp.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Team.class)
public abstract class Team_ {

	public static volatile SingularAttribute<Team, String> teamName;
	public static volatile SingularAttribute<Team, String> teamMember;
	public static volatile SingularAttribute<Team, Integer> score;
	public static volatile SetAttribute<Team, Game> games;
	public static volatile SingularAttribute<Team, Long> id;

	public static final String TEAM_NAME = "teamName";
	public static final String TEAM_MEMBER = "teamMember";
	public static final String SCORE = "score";
	public static final String GAMES = "games";
	public static final String ID = "id";

}

