package pl.chyla.luxdoc.application.sec;

/**
 * Created by Luxoft on 4/27/2016.
 */
public interface CurrentUserProvider {
    void ensureRole(String qm);
}
