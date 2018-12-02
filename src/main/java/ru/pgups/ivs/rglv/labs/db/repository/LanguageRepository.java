package ru.pgups.ivs.rglv.labs.db.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pgups.ivs.rglv.labs.db.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    @Query(""
        + "SELECT lang "
        + "FROM FilmLanguage lang "
        + "WHERE lower(lang.language) LIKE lower(CONCAT('%',:str,'%'))"
    )
    List<Language> findAllWhereLanguageNameContainsSubstring(@Param("str") String substr);
}
