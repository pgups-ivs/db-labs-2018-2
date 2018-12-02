package ru.pgups.ivs.rglv.labs.db.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pgups.ivs.rglv.labs.db.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query(""
        + "SELECT f FROM Film f JOIN f.categories fc WHERE fc.id = :categoryId ORDER by f.title"
    )
    List<Film> findAllForCategory(@Param("categoryId") Long categoryId);
}
