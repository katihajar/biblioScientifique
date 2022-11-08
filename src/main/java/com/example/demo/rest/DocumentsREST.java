package com.example.demo.rest;

import com.example.demo.document.Documents;
import com.example.demo.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/delete-multiple-by-id")
    public int deleteListDocumentById(@RequestBody List<Documents> documentsList) {
        return documentsService.deleteListDocumentById(documentsList);
    }

    @DeleteMapping("/id/{id}")
    public int deleteDocumentById(@PathVariable String id) {
        return documentsService.deleteDocumentById(id);
    }
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,@RequestParam("doc") Documents doc) throws IOException {
       System.out.println(doc);

        return new ResponseEntity<>(documentsService.addFile(file,doc), HttpStatus.OK);
    }

    @PostMapping("/getFile/{id}")
    public Documents getFile(@PathVariable String id) {
        return documentsService.getFile(id);
    }
}
