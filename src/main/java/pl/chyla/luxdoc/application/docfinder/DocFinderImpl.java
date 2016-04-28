package pl.chyla.luxdoc.application.docfinder;

import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DocFinderImpl implements  DocFinder {
    private final DocRepo repository;

    public DocFinderImpl(DocRepo docRepo) {
        repository = docRepo;
    }

    @Override
    public Map<String, String> findOne(UUID uuid) {
        return toMap(repository.load(uuid));
    }

    @Override
    public Map<String, String> findOne(UUID uuid, String projection) {
        switch (projection.toUpperCase()) {
            case "FULL": return toMap(repository.load(uuid));
            case "SIMPLE": return toSimpleMap(repository.load(uuid));
            default: throw new RuntimeException("Unsupported kind: " + projection);
        }
    }

    private Map<String, String> toMap(QDocument load) {

        Map<String, String> m = new HashMap<String, String>();
        m.put("uuid", load.getUuid().toString());
        m.put("content", load.getContent());
        m.put("kind", load.getQualitySystem().toString());
        return m;
    }

    private Map<String, String> toSimpleMap(QDocument load) {
        Map<String, String> map = toMap(load);
        map.remove("content");
        return map;
    }
}
