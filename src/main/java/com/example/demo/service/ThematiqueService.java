package com.example.demo.service;

import com.example.demo.document.Thematique;
import com.example.demo.document.Universite;
import com.example.demo.repository.ThematiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class ThematiqueService {
    @Autowired
    ThematiqueRepository thematiqueRepository;

    public Thematique findThematiqueById(String id) {
        return thematiqueRepository.findThematiqueById(id);
    }

    public Thematique findByDomaine(String domaine) {
        return thematiqueRepository.findByDomaine(domaine);
    }

    public List<Thematique> findAll() {
        return thematiqueRepository.findAll();
    }
    @Transactional
    public int deleteThematiqueById(String id) {
        return thematiqueRepository.deleteThematiqueById(id);
    }
    @Transactional
    public int deleteListThematiqueById(List<Thematique> thematiqueList) {
        int res = 0;
        for (int i = 0; i < thematiqueList.size(); i++) {
            res += deleteThematiqueById(thematiqueList.get(i).getId());
        }
        return res;
    }

    public Thematique save(Thematique entity) {
        Thematique them = findByDomaine(entity.getDomaine());
        if(them==null) {
            return thematiqueRepository.save(entity);
        }else{
            return null;
        }
    }
}
