package pl.chyla.luxdoc.infrastructure.persistance.docflow;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.UUID;

@Repository
public interface JPADocRepository extends CrudRepository<QDocument, UUID> {
}
