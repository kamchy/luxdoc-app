package pl.chyla.luxdoc.infrastructure.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.chyla.luxdoc.application.docfinder.DocFinder;
import pl.chyla.luxdoc.application.docfinder.DocFinderImpl;
import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.infrastructure.persistance.docflow.JPADocRepository;
import pl.chyla.luxdoc.infrastructure.persistance.docflow.H2DocRepo;

@Configuration
@EnableJpaRepositories
public class DocFinderConfig {

    private final JPADocRepository repository;

    @Autowired
    public DocFinderConfig(JPADocRepository repository) {
        this.repository = repository;
    }

    @Bean
    DocRepo docRepo() {
        return new H2DocRepo(repository);
    }

    @Bean
    DocFinder docFinder(DocRepo repo) {
        return new DocFinderImpl(repo);
    }

}
