package pl.chyla.luxdoc.infrastructure.persistance.docflow;

import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.UUID;


public class H2DocRepo implements DocRepo {
    private final JPADocRepository repository;

    public H2DocRepo(JPADocRepository repository) {
        this.repository = repository;
    }


    @Override
    public UUID save(QDocument qDocument) {
        repository.save(qDocument);
        return  qDocument.getUuid();
    }

    @Override
    public QDocument load(UUID docId) {
        return repository.findOne(docId);
    }

    @Override
    public Iterable<QDocument> findAll() {
        return repository.findAll();
    }
}
