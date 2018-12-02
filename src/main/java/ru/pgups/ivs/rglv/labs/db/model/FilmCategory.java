package ru.pgups.ivs.rglv.labs.db.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "FilmCategory")
@Table(name = "category")
public class FilmCategory {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Film> films;

    public FilmCategory() {
    }

    public FilmCategory(String name) {
        this.name = name;
    }

    public FilmCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmCategory that = (FilmCategory) o;

        if (id != that.id) return false;
        return name.equals(that.name);
    }
}
