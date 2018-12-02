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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Film")
@Table(name = "film")
public class Film {
    @Id @GeneratedValue
    @Column(name = "film_id")
    private long id;

    private String title;
    private String description;
    private int releaseYear;
    private int length;
    private int rentalDuration;
    private double rentalRate;
    private double replacementCost;

    @Column(name = "rating")
    private String mpaaRating;

    // todo Postgres array types mapping for JPA is not supported 'out-of-the-box', so some shamanism needed here
    //      as example, see https://stackoverflow.com/questions/1647583/mapping-a-postgresql-array-with-hibernate
    // private List<String> specialFeatures;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "film_actor",
        joinColumns = @JoinColumn(name = "film_id",  referencedColumnName = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    )
    private Set<Actor> actors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "film_category",
        joinColumns = @JoinColumn(name = "film_id",  referencedColumnName = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    )
    private Set<FilmCategory> categories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="language_id", nullable=false)
    private Language language;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<FilmCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<FilmCategory> categories) {
        this.categories = categories;
    }
}
