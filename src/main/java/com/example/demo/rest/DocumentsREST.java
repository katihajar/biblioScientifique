package com.example.demo.rest;

import com.example.demo.document.Documents;
import com.example.demo.document.Thematique;
import com.example.demo.document.User;
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
    @GetMapping("/docs/")
    public List<Documents> findByVisibiliteAndStatut() {
        return documentsService.findByVisibiliteAndStatut(true, true);
    }

    @PostMapping("/delete-multiple-by-id")
    public int deleteListDocumentById(@RequestBody List<Documents> documentsList) {
        return documentsService.deleteListDocumentById(documentsList);
    }

    @DeleteMapping("/id/")
    public int deleteDocumentById(@RequestParam("id") String id) {
        return documentsService.deleteDocumentById(id);
    }



    @PostMapping("/upload")
        public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,@RequestParam("visi") Boolean vs,@RequestParam("user") String user,@RequestParam("them") String them) throws IOException {
            Documents doc = documentsService.addFile(file,vs,user,them);
            return new ResponseEntity(doc, HttpStatus.OK);
        }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Documents entity) {
        Documents doc1 = documentsService.save1(entity);
        return new ResponseEntity(doc1, HttpStatus.OK);
    }

    @PostMapping("/getFile/{id}")
    public Documents getFile(@PathVariable String id) {
        return documentsService.getFile(id);
    }

    @PutMapping("/")
    public Documents update(@RequestBody Documents doc) {
        return documentsService.update(doc);
    }

    @GetMapping("/doc/id/{id}")
    public List<Documents> findByUserId(@PathVariable String id) {
        return documentsService.findByUserId(id);
    }

    @PutMapping("/visib/")
    public Documents changeVisib(@RequestParam("id") String id,@RequestParam("vs") Boolean vs) {
        return documentsService.changeVisib(id, vs);
    }
}
