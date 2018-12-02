package ru.pgups.ivs.rglv.labs.db.springboot.examples;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.pgups.ivs.rglv.labs.db.model.Actor;
import ru.pgups.ivs.rglv.labs.db.model.Film;

@Component
public class HibernateQueryExample implements LabExample {
    private static final Logger log = LoggerFactory.getLogger(HibernateQueryExample.class);

    public static final String description =
        "Example of EntityManager access and use of query method.";

    private EntityManager em;

    public HibernateQueryExample(EntityManager em) {
        this.em = em;
    }

    @Override
    public void runExample() {
        categoriesQuery();

        actorsQuery();

        languagesQuery();

        queryWithMaxResults();
    }

    private void categoriesQuery() {
        Query filmQuery = em.createQuery("from FilmCategory fc");

        List resultList = filmQuery.getResultList();

        log.info("{}", resultList);
    }

    private void languagesQuery() {
        Query langs = em.createQuery("from FilmLanguage fl order by name desc");

        log.info("{}", langs.getResultList());

    }

    private void actorsQuery() {
        Query actors = em.createQuery("from Actor a");

        List actorsList = actors.getResultList();

        log.info("{}", actorsList);
    }

    private void queryWithMaxResults() {
        Query filmsQuery = em.createQuery("from Film f").setMaxResults(30);

        List<Film> films = (List<Film>) filmsQuery.getResultList();

        log.info("{}", films);

        for (Film film : films) {
            log.info("{} ({}) (in {})", film.getTitle(), film.getMpaaRating(), film.getLanguage().getLanguage().trim());
            Set<Actor> actors = film.getActors();
            if (!actors.isEmpty()) {
                log.info(" actors: {}", actors);
            }
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

}
