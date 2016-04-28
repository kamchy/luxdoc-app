package pl.chyla.luxdoc.infrastructure.persistance.docflow;

import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Luxoft on 4/27/2016.
 */

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
}
