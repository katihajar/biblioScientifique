package com.example.demo.service;

import com.example.demo.document.Documents;
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
        return universiteRepository.findAll();
    }

    public Universite save(Universite entity) {
        return universiteRepository.save(entity);
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
    public int deleteUniversiteById(Long id) {
        int deleteByid= universiteRepository.deleteUniversiteById(id);
        return deleteByid;
    }


}
