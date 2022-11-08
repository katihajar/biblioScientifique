package com.example.demo.service;

import com.example.demo.document.Documents;
import com.example.demo.document.Thematique;
import com.example.demo.document.Universite;
import com.example.demo.repository.DocumentsRepository;
import com.example.demo.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;

    public Universite findByLibelle(String libelle) {
        return universiteRepository.findByLibelle(libelle);
    }

    public List<Universite> findAll() {
        List<Universite> e =universiteRepository.findAll();
        System.out.println(e);
        return universiteRepository.findAll();
    }

    public Universite save(Universite entity) {
        Universite universite = findByLibelle(entity.getLibelle());
        if(universite==null) {
            return universiteRepository.save(entity);
        }else{
            return null;
        }
    }
    @Transactional
    public int deleteListUniversiteById(List<Universite> universiteList) {
        int res = 0;
        for (int i = 0; i < universiteList.size(); i++) {
            res += deleteUniversiteById(universiteList.get(i).getId());
        }
        return res;
    }

    @Transactional
    public int deleteUniversiteById(String id) {
        int deleteByid= universiteRepository.deleteUniversiteById(id);
        return deleteByid;
    }


}
