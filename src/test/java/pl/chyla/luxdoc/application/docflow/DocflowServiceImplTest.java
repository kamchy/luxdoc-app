 package pl.chyla.luxdoc.application.docflow;

import org.junit.Test;
import org.mockito.Mockito;
import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by Luxoft on 4/27/2016.
 */


public class DocflowServiceImplTest {


    @Test
    public void shouldCreateDoc() throws Exception {
        CurrentUserProvider provider = Mockito.mock(CurrentUserProvider.class);

        DocRepo repo = createTestRepo();

        ConfigurationProvider config = Mockito.mock(ConfigurationProvider.class);
        DocflowServiceImpl impl = new DocflowServiceImpl(repo, provider, config);
        impl.create();

        assertTrue(repo.load(UUID.randomUUID()) != null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotCreateDoc() throws Exception {
        CurrentUserProvider provider = Mockito.mock(CurrentUserProvider.class);
        doThrow(new RuntimeException()).when(provider).ensureRole("QM");

        DocRepo repo = createTestRepo();

        ConfigurationProvider config = Mockito.mock(ConfigurationProvider.class);
        DocflowServiceImpl impl = new DocflowServiceImpl(repo, provider, config);
        impl.create();
    }



    @Test
    public void shuouldBeIso() throws Exception {
        DocRepo repo = createTestRepo();
        CurrentUserProvider provider = Mockito.mock(CurrentUserProvider.class);
        ConfigurationProvider config = Mockito.mock(ConfigurationProvider.class);
        when(config.getQualitySystem()).thenReturn(QualitySystem.ISO);
        DocflowServiceImpl impl = new DocflowServiceImpl(repo, provider, config);
        impl.create();

        QDocument doc = repo.load(UUID.randomUUID());
        assertEquals(doc.getQualitySystem(), QualitySystem.ISO);
    }

    private DocRepo createTestRepo() {
        return new DocRepo() {
            private QDocument last;
            @Override
            public void save(QDocument qDocument) {
                last = qDocument;
            }

            @Override
            public QDocument load(UUID docId) {
                return last;
            }
        };
    }
}