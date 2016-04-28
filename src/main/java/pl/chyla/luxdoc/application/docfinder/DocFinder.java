package pl.chyla.luxdoc.application.docfinder;

import java.util.Map;
import java.util.UUID;


public interface DocFinder {
    Map<String, String> findOne(UUID uuid);
    Map<String, String> findOne(UUID uuid, String projection);
}