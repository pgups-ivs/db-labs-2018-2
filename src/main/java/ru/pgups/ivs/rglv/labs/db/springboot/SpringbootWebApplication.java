package ru.pgups.ivs.rglv.labs.db.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("ru.pgups.ivs.rglv.labs.db.model")
@EnableJpaRepositories("ru.pgups.ivs.rglv.labs.db.repository")
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}
}
