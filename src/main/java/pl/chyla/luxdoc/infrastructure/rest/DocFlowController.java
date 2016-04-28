package pl.chyla.luxdoc.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.chyla.luxdoc.application.docflow.DocRepo;
import pl.chyla.luxdoc.application.docflow.DocflowService;
import pl.chyla.luxdoc.application.docflow.QDocument;

import javax.websocket.server.PathParam;
import java.util.UUID;

/**
 * Created by Luxoft on 4/27/2016.
 */
@RestController
@RequestMapping("/documents")
public class DocFlowController {
    private final DocflowService docFlowService;
    private final DocRepo docReposi;

    @Autowired
    public DocFlowController(DocflowService dfService, DocRepo docRepo) {
        docFlowService = dfService;
        docReposi = docRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    UUID createDocument() {
        return docFlowService.create();
    }

    @RequestMapping("/{uuid}")
    QDocument getDocument(@PathVariable("uuid") UUID uuid) {
        return docReposi.load(uuid);
    }
}
