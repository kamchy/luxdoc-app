package pl.chyla.luxdoc.application.docflow;

import java.util.UUID;

public interface DocRepo {
    UUID save(QDocument qDocument);
    QDocument load(UUID docId);
}
