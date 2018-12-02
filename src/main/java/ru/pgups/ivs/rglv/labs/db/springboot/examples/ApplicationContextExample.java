package ru.pgups.ivs.rglv.labs.db.springboot.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextExample implements LabExample, ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(ApplicationContextExample.class);

    public static final String description =
        "Example of ApplicationContext access and use of getBean(class) to get DataSource instance.";

    private ApplicationContext applicationContext;

    @Override
    public void runExample() {
        DataSource ds = applicationContext.getBean(DataSource.class);

        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT count(*) FROM film");
             ResultSet rs = statement.executeQuery();
        ) {
            rs.next();
            log.info("Films count: {}", rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
