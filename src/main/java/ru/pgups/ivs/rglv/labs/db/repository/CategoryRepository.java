package ru.pgups.ivs.rglv.labs.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pgups.ivs.rglv.labs.db.model.FilmCategory;

public interface CategoryRepository extends JpaRepository<FilmCategory, Long> {
}
