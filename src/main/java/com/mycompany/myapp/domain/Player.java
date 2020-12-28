package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Player.
 */
@Entity
@Table(name = "player")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "avatar", nullable = false)
    private String avatar;

    @NotNull
    @Column(name = "score", nullable = false)
    private Integer score;

    @NotNull
    @Column(name = "id_account", nullable = false, unique = true)
    private String idAccount;

    @OneToMany(mappedBy = "idAccount")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Team> teams = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public Player avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getScore() {
        return score;
    }

    public Player score(Integer score) {
        this.score = score;
        return this;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public Player idAccount(String idAccount) {
        this.idAccount = idAccount;
        return this;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public Player teams(Set<Team> teams) {
        this.teams = teams;
        return this;
    }

    public Player addTeam(Team team) {
        this.teams.add(team);
        team.setIdAccount(this);
        return this;
    }

    public Player removeTeam(Team team) {
        this.teams.remove(team);
        team.setIdAccount(null);
        return this;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        return id != null && id.equals(((Player) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Player{" +
            "id=" + getId() +
            ", avatar='" + getAvatar() + "'" +
            ", score=" + getScore() +
            ", idAccount='" + getIdAccount() + "'" +
            "}";
    }
}
