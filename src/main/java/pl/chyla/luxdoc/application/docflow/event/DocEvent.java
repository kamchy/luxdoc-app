package pl.chyla.luxdoc.application.docflow.event;

public class DocEvent {
    private final String message;

    public DocEvent(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
