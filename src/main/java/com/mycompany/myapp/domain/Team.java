package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Team.
 */
@Entity
@Table(name = "team")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "team_name", nullable = false, unique = true)
    private String teamName;

    @NotNull
    @Column(name = "team_member", nullable = false, unique = true)
    private String teamMember;

    @NotNull
    @Column(name = "score", nullable = false)
    private Integer score;

    @OneToMany(mappedBy = "game")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Game> games = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team teamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public Team teamMember(String teamMember) {
        this.teamMember = teamMember;
        return this;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public Integer getScore() {
        return score;
    }

    public Team score(Integer score) {
        this.score = score;
        return this;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Set<Game> getGames() {
        return games;
    }

    public Team games(Set<Game> games) {
        this.games = games;
        return this;
    }

    public Team addGame(Game game) {
        this.games.add(game);
        game.setGame(this);
        return this;
    }

    public Team removeGame(Game game) {
        this.games.remove(game);
        game.setGame(null);
        return this;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Team)) {
            return false;
        }
        return id != null && id.equals(((Team) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Team{" +
            "id=" + getId() +
            ", teamName='" + getTeamName() + "'" +
            ", teamMember='" + getTeamMember() + "'" +
            ", score=" + getScore() +
            "}";
    }
}
