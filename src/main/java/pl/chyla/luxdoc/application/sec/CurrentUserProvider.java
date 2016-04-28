package pl.chyla.luxdoc.application.sec;

public interface CurrentUserProvider {
    void ensureRole(String qm);
}
