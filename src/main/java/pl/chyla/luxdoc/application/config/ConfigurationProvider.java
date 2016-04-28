package pl.chyla.luxdoc.application.config;

import pl.chyla.luxdoc.application.docflow.QualitySystem;

/**
 * Created by Luxoft on 4/27/2016.
 */
public interface ConfigurationProvider {
    QualitySystem getQualitySystem();
}
