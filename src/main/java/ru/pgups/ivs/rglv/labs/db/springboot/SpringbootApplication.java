package ru.pgups.ivs.rglv.labs.db.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.pgups.ivs.rglv.labs.db.springboot.examples.LabExample;

@Profile("db-example")
@SpringBootApplication
@EntityScan("ru.pgups.ivs.rglv.labs.db.model")
@EnableJpaRepositories("ru.pgups.ivs.rglv.labs.db.repository")
public class SpringbootApplication {
    public static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);

        applicationContext.getBeansOfType(LabExample.class).values().forEach(
            example -> {
                log.info(" - - - - - - - - - - - - - - - -");
                log.info(example.getDescription());
                example.runExample();
            }
        );
    }
}
