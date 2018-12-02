package ru.pgups.ivs.rglv.labs.db.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pgups.ivs.rglv.labs.db.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query(""
        + "SELECT film.actors FROM Film film WHERE film.id = :filmId"
    )
    List<Actor> listActorsForFilm(@Param("filmId") long id);
}
