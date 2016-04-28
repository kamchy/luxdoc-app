package pl.chyla.luxdoc.application.docflow.event;

public interface EventBus {
    void publish(DocEvent event);
}
