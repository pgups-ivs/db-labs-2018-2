package ru.pgups.ivs.rglv.labs.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FilmLanguage")
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue
    @Column(name = "language_id")
    private long id;

    @Column(name = "name")
    private String language;

    public Language() {
    }

    public Language(String language) {
        this.language = language;
    }

    public Language(long id, String language) {
        this.id = id;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Language{" +
            "id=" + id +
            ", language='" + language + '\'' +
            '}';
    }
}
