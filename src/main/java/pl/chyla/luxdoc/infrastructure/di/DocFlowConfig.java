package pl.chyla.luxdoc.infrastructure.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.config.DefaultContentProvider;
import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.DocflowService;
import pl.chyla.luxdoc.application.docflow.DocflowServiceImpl;
import pl.chyla.luxdoc.application.docflow.event.EventBus;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;

/**
 * Created by Luxoft on 4/27/2016.
 */

@Configuration
public class DocFlowConfig {
    @Autowired
    ApplicationEventPublisher publisher;

    @Bean
    public DocflowService getService(DocRepo repo, CurrentUserProvider cuProvider, ConfigurationProvider provider,
                                     DefaultContentProvider defaultContentProvider, EventBus bus) {
        return new DocflowServiceImpl(repo, cuProvider, provider, defaultContentProvider, bus);
    }

    @Bean
    EventBus eventBus(ApplicationEventPublisher publisher) {
        return new SpringSingleThreadBus(publisher);
    }
}
