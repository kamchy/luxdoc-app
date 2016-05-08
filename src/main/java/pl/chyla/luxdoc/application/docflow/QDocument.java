package pl.chyla.luxdoc.application.docflow;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class QDocument {
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private QualitySystem qualitySystem;
    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "content")
    private String content;


    public QDocument(){
        // required by jpa
    }
    public QDocument(QualitySystem system, UUID id) {
        this.qualitySystem = system;
        this.content = "";
        this.uuid = id;
    }

    public QualitySystem getQualitySystem() {
        return qualitySystem;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


    public UUID getUuid() {
        return uuid;
    }
}
