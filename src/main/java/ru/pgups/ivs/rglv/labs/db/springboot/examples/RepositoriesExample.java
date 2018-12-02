package ru.pgups.ivs.rglv.labs.db.springboot.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import ru.pgups.ivs.rglv.labs.db.model.FilmCategory;
import ru.pgups.ivs.rglv.labs.db.repository.ActorRepository;
import ru.pgups.ivs.rglv.labs.db.repository.CategoryRepository;
import ru.pgups.ivs.rglv.labs.db.repository.LanguageRepository;

@Component
public class RepositoriesExample implements LabExample {
    private static final Logger log = LoggerFactory.getLogger(RepositoriesExample.class);

    private static final String description = "Example of JpaRepository use. See https://docs.spring.io/spring-data/jpa/docs/current/reference/html/";

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void runExample() {
        customQueryMethodExample();

        exampleMatcherExample();

        actorRepository.listActorsForFilm(40L);
    }

    private void exampleMatcherExample() {
        log.info("This is example of Example search with customized matcher.");
        log.info("Result: {}",
            categoryRepository.findAll(
                Example.of(
                    new FilmCategory("dRamA"),
                    ExampleMatcher.matching()
                        .withIgnorePaths("id")
                        .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.ignoreCase())
                )
            )
        );
    }

    private void customQueryMethodExample() {
        log.info("This is example of custom method use - "
            + "calling findAllWhereLanguageNameContainsSubstring() to find all languages with "
            + "'en' in name");
        log.info("Result: {}", languageRepository.findAllWhereLanguageNameContainsSubstring("en"));
    }

    @Override
    public String getDescription() {
        return description;
    }
}
