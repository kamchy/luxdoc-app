package pl.chyla.luxdoc.application.docflow;

import org.springframework.beans.factory.annotation.Autowired;
import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;

/**
 * Created by Luxoft on 4/27/2016.
 */
public class DocflowServiceImpl implements DocflowService {
    private DocRepo repo;
    private CurrentUserProvider currentUserProvider;
    private ConfigurationProvider configurationProvider;

    public DocflowServiceImpl(DocRepo repo, CurrentUserProvider currentUserProvider, ConfigurationProvider configurationProvider) {
        this.repo = repo;
        this.currentUserProvider = currentUserProvider;
        this.configurationProvider = configurationProvider;
    }

    @Override
    public void create() {
        currentUserProvider.ensureRole("QM");
        QualitySystem system = configurationProvider.getQualitySystem();
        QDocument qDocument = new QDocument(system);
        repo.save(qDocument);
    }

    @Override
    public void verify() {

    }

    @Override
    public void publish() {

    }

    @Override
    public void archive() {

    }
}
