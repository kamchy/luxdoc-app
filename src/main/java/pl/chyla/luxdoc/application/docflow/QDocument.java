package pl.chyla.luxdoc.application.docflow;

/**
 * Created by Luxoft on 4/27/2016.
 */
public class QDocument {
    private final QualitySystem qualitySystem;

    public QDocument(QualitySystem system) {
        this.qualitySystem = system;
    }

    public QualitySystem getQualitySystem() {
        return qualitySystem;
    }
}
