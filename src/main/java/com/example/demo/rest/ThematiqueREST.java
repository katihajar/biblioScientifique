package com.example.demo.rest;

import com.example.demo.document.Thematique;
import com.example.demo.service.ThematiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thematique")
public class ThematiqueREST {
    @Autowired
    ThematiqueService thematiqueService;

    @GetMapping("/domaine/{domaine}")
    public Thematique findByDomaine(@PathVariable String domaine) {
        return thematiqueService.findByDomaine(domaine);
    }
    @GetMapping("/")
    public List<Thematique> findAll() {
        return thematiqueService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public int deleteThematiqueById(@PathVariable String id) {
        return thematiqueService.deleteThematiqueById(id);
    }

    @PostMapping("/delete-multiple-by-id")
    public int deleteListThematiqueById(@RequestBody List<Thematique> thematiqueList) {
        return thematiqueService.deleteListThematiqueById(thematiqueList);
    }
    @PostMapping("/")
    public Thematique save(@RequestBody Thematique entity) {
        return thematiqueService.save(entity);
    }
}
