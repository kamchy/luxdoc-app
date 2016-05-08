package pl.chyla.luxdoc.application.docfinder;

import pl.chyla.luxdoc.application.docflow.QDocument;

import java.util.Map;
import java.util.UUID;


public interface DocFinder {
    Map<String, String> findOne(UUID uuid);
    Map<String, String> findOne(UUID uuid, String projection);

    Iterable<QDocument> findAll();
}
