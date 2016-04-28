package pl.chyla.luxdoc.application.docflow;

public class QDocument {
    private final QualitySystem qualitySystem;
    private String content;

    public QDocument(QualitySystem system) {
        this.qualitySystem = system;
        this.content = "";
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
}
