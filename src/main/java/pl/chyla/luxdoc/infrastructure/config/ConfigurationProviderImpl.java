package pl.chyla.luxdoc.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import pl.chyla.luxdoc.application.config.ConfigurationProvider;
import pl.chyla.luxdoc.application.docflow.QualitySystem;

@Component
public class ConfigurationProviderImpl implements ConfigurationProvider {

    private final Environment environ;

    @Autowired
    public ConfigurationProviderImpl(Environment env) {
        environ = env;
    }
    @Override
    public QualitySystem getQualitySystem() {
        return environ.getProperty("quality.system.name", QualitySystem.class);
    }
}
