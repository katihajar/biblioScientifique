package com.example.demo.rest;

import com.example.demo.document.Documents;
import com.example.demo.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentsREST {
    @Autowired
    DocumentsService documentsService;

    @GetMapping("/title/{titre}")
    public Documents findByTitre(@PathVariable String titre) {
        return documentsService.findByTitre(titre);
    }
    @GetMapping("/")
    public List<Documents> findAll() {
        return documentsService.findAll();
    }
    @PostMapping("/")
    public Documents save(Documents entity) {
        return documentsService.save(entity);
    }
    @PostMapping("/delete-multiple-by-id")
    public int deleteListDocumentById(@RequestBody List<Documents> documentsList) {
        return documentsService.deleteListDocumentById(documentsList);
    }

    @DeleteMapping("/id/{id}")
    public int deleteDocumentById(@PathVariable Long id) {
        return documentsService.deleteDocumentById(id);
    }
}
