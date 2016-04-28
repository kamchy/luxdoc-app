package pl.chyla.luxdoc.infrastructure.persistance.docflow;

import org.springframework.stereotype.Repository;
import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.UUID;

/**
 * Created by Luxoft on 4/27/2016.
 */
@Repository
public class MongoDocRepo implements DocRepo {
    @Override
    public void save(QDocument qDocument) {

    }

    @Override
    public QDocument load(UUID docId) {
        return null;
    }
}
