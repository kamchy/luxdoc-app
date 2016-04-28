package pl.chyla.luxdoc.application.docflow;

/**
 * Created by Luxoft on 4/27/2016.
 */
public interface DocflowService {
    void create();
    void verify();
    void publish();
    void archive();
}
