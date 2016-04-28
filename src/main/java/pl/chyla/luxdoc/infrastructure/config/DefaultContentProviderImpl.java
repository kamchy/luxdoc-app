package pl.chyla.luxdoc.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import pl.chyla.luxdoc.application.config.DefaultContentProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

/**
 * Created by Luxoft on 4/28/2016.
 */
@Component
public class DefaultContentProviderImpl implements pl.chyla.luxdoc.application.config.DefaultContentProvider {

    private final ResourceLoader lo;
    static Logger LOG = LoggerFactory.getLogger(DefaultContentProvider.class);

    @Autowired
    public DefaultContentProviderImpl(ResourceLoader rLoader) {
        lo = rLoader;
    }
    @Override
    public String getDefaultDocumentContent() {
        Resource res = lo.getResource("classpath:default-content.txt");
        String out = "";
        try {
             out = Files.readAllLines(res.getFile().toPath()).stream().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("DEFAULT is" + out);
        return out;
    }
}
