package pl.chyla.luxdoc.infrastructure.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.chyla.luxdoc.application.config.DefaultContentProvider;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DefaultContentProviderImplTest {

    @Autowired
    DefaultContentProvider prov;

    @Test
    public void test() throws Exception {
        String defaultOutput = prov.getDefaultDocumentContent();
        assertEquals(defaultOutput, "ss");

    }
}