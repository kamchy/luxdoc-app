package pl.chyla.luxdoc.application.config;

import pl.chyla.luxdoc.application.docflow.QualitySystem;

public interface ConfigurationProvider {
    QualitySystem getQualitySystem();
}
