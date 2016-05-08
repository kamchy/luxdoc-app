package pl.chyla.luxdoc.application.docflow;

import java.util.UUID;

public interface DocflowService {
    UUID create();
    void verify();
    void publish();
    void archive();
}
