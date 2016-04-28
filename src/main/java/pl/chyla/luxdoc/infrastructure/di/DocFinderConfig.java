package pl.chyla.luxdoc.infrastructure.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.chyla.luxdoc.application.docfinder.DocFinder;
import pl.chyla.luxdoc.application.docfinder.DocFinderImpl;
import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.infrastructure.persistance.docfinder.SimpleDocFinder;
import pl.chyla.luxdoc.infrastructure.persistance.docflow.MongoDocRepo;

@Configuration
public class DocFinderConfig {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DocFinderConfig(JdbcTemplate template) {
        jdbcTemplate = template;
    }

    @Bean
    DocRepo docRepo() {
        return new MongoDocRepo();
    }

    @Bean
    DocFinder docFinder(DocRepo repo) {
        return new DocFinderImpl(repo);
    }

}
