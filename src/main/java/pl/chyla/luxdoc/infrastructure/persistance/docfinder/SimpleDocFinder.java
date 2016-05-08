package pl.chyla.luxdoc.infrastructure.persistance.docfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.chyla.luxdoc.application.docfinder.DocFinder;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class SimpleDocFinder implements DocFinder {

    private final JdbcTemplate template;

    Map<String, String> projections = new HashMap<>();

    @Autowired
    public SimpleDocFinder(JdbcTemplate repo) {
        template = repo;
        projections.put("SIMPLE", "uuid,type");
        projections.put("FULL", "uuid,content,type");
    }

    @Override
    public Map<String, String> findOne(UUID uuid) {
        return findOne(UUID.randomUUID(), "FULL");
    }

    @Override
    public Map<String, String> findOne(UUID uuid, String projection) {
        Map<String, Object> res = template.queryForMap("select " + projections.get(projection) + " from qdoc" );
        return res.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> v.toString()));
    }

    @Override
    public Iterable<QDocument> findAll() {
        return template.queryForList("select * from qdoc", QDocument.class);
    }
}
