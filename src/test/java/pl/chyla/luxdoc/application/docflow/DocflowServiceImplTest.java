 package pl.chyla.luxdoc.application.docflow;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.config.DefaultContentProvider;
import pl.chyla.luxdoc.application.docflow.event.DocEvent;
import pl.chyla.luxdoc.application.docflow.event.EventBus;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;



public class DocflowServiceImplTest {


    @Test
    public void shouldCreateDoc() throws Exception {
        CurrentUserProvider provider = Mockito.mock(CurrentUserProvider.class);

        DocRepo repo = createTestRepo();

        ConfigurationProvider config = Mockito.mock(ConfigurationProvider.class);
        DocflowServiceImpl impl = new DocflowServiceImpl(repo, provider, config, defTextMock(), defEventBus() );
        impl.create();

        assertTrue(repo.load(UUID.randomUUID()) != null);
    }

    private EventBus defEventBus() {
        return new EventBus() {
            @Override
            public void publish(DocEvent event) {
                System.out.printf("published " + event);
            }
        };
    }

    private DefaultContentProvider defTextMock() {
        return Mockito.mock(DefaultContentProvider.class);
    }

    @Test(expected = RuntimeException.class)
    @Ignore
    public void shouldNotCreateDoc() throws Exception {
        CurrentUserProvider provider = Mockito.mock(CurrentUserProvider.class);
        doThrow(new RuntimeException()).when(provider).ensureRole("QM");

        DocRepo repo = createTestRepo();

        ConfigurationProvider config = Mockito.mock(ConfigurationProvider.class);
        DocflowServiceImpl impl = new DocflowServiceImpl(repo, provider, config, defTextMock(), defEventBus());
        impl.create();
    }



    @Test
    public void shuouldBeIso() throws Exception {
        DocRepo repo = createTestRepo();
        CurrentUserProvider provider = Mockito.mock(CurrentUserProvider.class);
        ConfigurationProvider config = Mockito.mock(ConfigurationProvider.class);
        when(config.getQualitySystem()).thenReturn(QualitySystem.ISO);
        DocflowServiceImpl impl = new DocflowServiceImpl(repo, provider, config, defTextMock(), defEventBus());
        impl.create();

        QDocument doc = repo.load(UUID.randomUUID());
        assertEquals(doc.getQualitySystem(), QualitySystem.ISO);
    }

    private DocRepo createTestRepo() {
        return new DocRepo() {
            private QDocument last;
            @Override
            public UUID save(QDocument qDocument) {
                last = qDocument;
                return UUID.randomUUID();
            }

            @Override
            public QDocument load(UUID docId) {
                return last;
            }
        };
    }
}
