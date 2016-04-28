package pl.chyla.luxdoc.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.chyla.luxdoc.application.docflow.DocflowService;

/**
 * Created by Luxoft on 4/27/2016.
 */
@RestController("/documents")
public class DocFlowController {
    private final DocflowService docFlowService;

    @Autowired
    public DocFlowController(DocflowService dfService) {
        docFlowService = dfService;
    }

    @RequestMapping(method = RequestMethod.POST)
    void createDocument() {
        docFlowService.create();
    }
}
