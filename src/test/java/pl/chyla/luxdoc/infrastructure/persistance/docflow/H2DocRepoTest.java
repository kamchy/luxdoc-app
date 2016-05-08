package pl.chyla.luxdoc.infrastructure.persistance.docflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.config.DefaultContentProvider;
import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.DocflowService;
import pl.chyla.luxdoc.application.docflow.QDocument;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;
import pl.chyla.luxdoc.infrastructure.config.ConfigurationProviderImpl;
import pl.chyla.luxdoc.infrastructure.config.DefaultContentProviderImpl;
import pl.chyla.luxdoc.infrastructure.di.DbConfig;
import pl.chyla.luxdoc.infrastructure.di.DocFinderConfig;
import pl.chyla.luxdoc.infrastructure.di.DocFlowConfig;

import javax.sql.DataSource;
import java.util.UUID;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {H2DocRepoTest.TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)

public class H2DocRepoTest {


    @Configuration
    @Import({DocFinderConfig.class, DocFlowConfig.class, DbConfig.class})
    static class TestConfig {
        @Autowired
        Environment environment;
        @Autowired
        ResourceLoader loader;
        @Bean
        DefaultContentProvider defaultContentProvider() {
            return new DefaultContentProviderImpl(loader);
        }
        @Bean
        ConfigurationProvider configurationProvider() {
            return new ConfigurationProviderImpl(environment);
        }
        @Bean
        CurrentUserProvider provider() {
            return new CurrentUserProvider() {
                @Override
                public void ensureRole(String qm) {
                    // all roles allowed
                }
            };
        }

        @Bean
        public DataSource dataSource() {

            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            return builder.setType(EmbeddedDatabaseType.H2).
                    addScript("db/create-db.sql").build();
        }


    }
    @Autowired
    DocRepo repo;

    @Autowired
    DocflowService service;



    @Test
    public void test() {
        final UUID uuid = service.create();
        QDocument doc = repo.load(uuid);
        assertNotNull(doc);
    }
}
