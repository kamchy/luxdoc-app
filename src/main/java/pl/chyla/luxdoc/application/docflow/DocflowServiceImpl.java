package pl.chyla.luxdoc.application.docflow;

import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.config.DefaultContentProvider;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;

import java.util.UUID;

/**
 * Created by Luxoft on 4/27/2016.
 */
public class DocflowServiceImpl implements DocflowService {
    private final DefaultContentProvider contentProvider;
    private DocRepo repo;
    private CurrentUserProvider currentUserProvider;
    private ConfigurationProvider configurationProvider;

    public DocflowServiceImpl(DocRepo repo, CurrentUserProvider currentUserProvider,
                              ConfigurationProvider configurationProvider, DefaultContentProvider contentProvider) {
        this.repo = repo;
        this.currentUserProvider = currentUserProvider;
        this.configurationProvider = configurationProvider;
        this.contentProvider = contentProvider;
    }

    @Override
    public UUID create() {
        //currentUserProvider.ensureRole("QM");
        QualitySystem system = configurationProvider.getQualitySystem();
        QDocument qDocument = new QDocument(system);
        String defaultDocumentContent = contentProvider.getDefaultDocumentContent();
        qDocument.setContent(defaultDocumentContent);
        return repo.save(qDocument);
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
