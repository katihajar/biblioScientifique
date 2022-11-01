package com.example.demo.rest;

import com.example.demo.document.Consultation;
import com.example.demo.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationREST {
    @Autowired
    ConsultationService consultationService;
    @GetMapping("/titre/{titre}")
    public List<Consultation> findByDocumentsTitre(@PathVariable String titre) {
        return consultationService.findByDocumentsTitre(titre);
    }
    @GetMapping("/username/{username}")
    public List<Consultation> findByUserUsername(@PathVariable String username) {
        return consultationService.findByUserUsername(username);
    }
    @GetMapping("/id/{id}")
    public Consultation findConsultationById(@PathVariable String id) {
        return consultationService.findConsultationById(id);
    }
    @GetMapping("/")
    public List<Consultation> findAll() {
        return consultationService.findAll();
    }
    @PostMapping("/")
    public Consultation save(@RequestBody Consultation entity) {
        return consultationService.save(entity);
    }
}
