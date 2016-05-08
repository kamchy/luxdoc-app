package pl.chyla.luxdoc.infrastructure.persistance.docflow;

import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.*;


public class MongoDocRepo implements DocRepo {

    private Map<UUID, QDocument> map = new HashMap<>();
    @Override
    public UUID save(QDocument qDocument) {
        UUID key = qDocument.getUuid();
        map.put(key, qDocument);
        return key;
    }

    @Override
    public QDocument load(UUID docId) {
        return map.get(docId);
    }

    @Override
    public Iterable<QDocument> findAll() {
        return new ArrayList<>(map.values());
    }
}
