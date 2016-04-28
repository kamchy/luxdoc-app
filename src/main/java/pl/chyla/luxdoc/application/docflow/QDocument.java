package pl.chyla.luxdoc.application.docflow;

import java.util.UUID;

public class QDocument {
    private final QualitySystem qualitySystem;
    private final UUID uuid;
    private String content;

    public QDocument(QualitySystem system, UUID id) {
        this.qualitySystem = system;
        this.content = "";
        this.uuid = id;
    }

    public QualitySystem getQualitySystem() {
        return qualitySystem;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public UUID getUuid() {
        return uuid;
    }
}
