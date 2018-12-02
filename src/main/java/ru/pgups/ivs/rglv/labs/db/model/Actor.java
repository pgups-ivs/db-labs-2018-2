package ru.pgups.ivs.rglv.labs.db.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Actor")
@Table(name = "actor")
public class Actor {
    @Id @GeneratedValue
    @Column(name = "actor_id")
    private long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "film_actor",
        joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "film_id",  referencedColumnName = "film_id")
    )
    private Set<Film> films;

    private String firstName;
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Actor{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
