package pl.chyla.luxdoc.application.docflow;

import java.util.UUID;

/**
 * Created by Luxoft on 4/27/2016.
 */
public interface DocflowService {
    UUID create();
    void verify();
    void publish();
    void archive();
}
