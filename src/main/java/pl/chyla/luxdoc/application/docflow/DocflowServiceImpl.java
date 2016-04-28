package pl.chyla.luxdoc.application.docflow;

import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.config.DefaultContentProvider;
import pl.chyla.luxdoc.application.docflow.event.DocEvent;
import pl.chyla.luxdoc.application.docflow.event.EventBus;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;

import java.util.UUID;

/**
 * Created by Luxoft on 4/27/2016.
 */
public class DocflowServiceImpl implements DocflowService {
    private final DefaultContentProvider contentProvider;
    private final EventBus bus;
    private DocRepo repo;
    private CurrentUserProvider currentUserProvider;
    private ConfigurationProvider configurationProvider;

    public DocflowServiceImpl(DocRepo repo, CurrentUserProvider currentUserProvider,
                              ConfigurationProvider configurationProvider, DefaultContentProvider contentProvider,
                              EventBus eventBus) {
        this.repo = repo;
        this.currentUserProvider = currentUserProvider;
        this.configurationProvider = configurationProvider;
        this.contentProvider = contentProvider;
        this.bus = eventBus;
    }

    @Override
    public UUID create() {
        //currentUserProvider.ensureRole("QM");
        QualitySystem system = configurationProvider.getQualitySystem();
        QDocument qDocument = new QDocument(system, UUID.randomUUID());
        String defaultDocumentContent = contentProvider.getDefaultDocumentContent();
        qDocument.setContent(defaultDocumentContent);
        repo.save(qDocument);
        bus.publish(new DocEvent(qDocument.getUuid() + " - event - fired"));
        return qDocument.getUuid();
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
