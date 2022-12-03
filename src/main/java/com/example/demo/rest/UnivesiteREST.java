package com.example.demo.rest;

import com.example.demo.document.Universite;
import com.example.demo.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universite")
public class UnivesiteREST {
    @Autowired
    UniversiteService universiteService;

    @GetMapping("/libelle/{libelle}")
    public Universite findByLibelle(@PathVariable String libelle) {
        return universiteService.findByLibelle(libelle);
    }
    @GetMapping("/all")
    public List<Universite> findAll() {
        System.out.println("hna");
        return universiteService.findAll();
    }
    @PostMapping("/")
    public Universite save(@RequestBody Universite entity) {
        return universiteService.save(entity);
    }

    @PostMapping("/delete-multiple-by-id")
    public int deleteListUniversiteById(@RequestBody List<Universite> universiteList) {
        return universiteService.deleteListUniversiteById(universiteList);
    }

    @DeleteMapping("/id/{id}")
    public int deleteUniversiteById(@PathVariable String id) {
        return universiteService.deleteUniversiteById(id);
    }
}
