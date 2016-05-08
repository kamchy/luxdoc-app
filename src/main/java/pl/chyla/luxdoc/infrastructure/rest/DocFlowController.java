package pl.chyla.luxdoc.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.chyla.luxdoc.application.docfinder.DocFinder;
import pl.chyla.luxdoc.application.docflow.DocflowService;
import pl.chyla.luxdoc.application.docflow.QDocument;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/documents")
public class DocFlowController {
    private final DocflowService docFlowService;
    private final DocFinder docFinder;

    @Autowired
    public DocFlowController(DocflowService dfService, DocFinder docFinder) {
        docFlowService = dfService;
        this.docFinder = docFinder;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity createDocument() {
        UUID uuid = docFlowService.create();
        return ResponseEntity.created(URI.create("/documents/" + uuid)).build();
    }

    @RequestMapping("/{uuid}")
    Map<String, String> getDocument(@PathVariable("uuid") UUID uuid) {
        return docFinder.findOne(uuid);
    }

    @RequestMapping("/randuuid")
    UUID randUUID() {
        return UUID.randomUUID();
    }

    @RequestMapping("/all")
    Iterable<QDocument> getDocument() {
        return docFinder.findAll();
    }


    @RequestMapping("/{uuid}/{kind}")
    Map<String, String> getDocumentSimple(@PathVariable("uuid") UUID uuid, @PathVariable("kind") String kind) {
        return docFinder.findOne(uuid, kind);
    }
}
