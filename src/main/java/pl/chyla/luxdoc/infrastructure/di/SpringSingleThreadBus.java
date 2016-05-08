package pl.chyla.luxdoc.infrastructure.di;

import org.springframework.context.ApplicationEventPublisher;
import pl.chyla.luxdoc.application.docflow.event.DocEvent;
import pl.chyla.luxdoc.application.docflow.event.EventBus;


public class SpringSingleThreadBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringSingleThreadBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(DocEvent event) {
        publisher.publishEvent(event);

    }
}
