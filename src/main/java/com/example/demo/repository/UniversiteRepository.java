package com.example.demo.repository;

import com.example.demo.document.Universite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends MongoRepository<Universite, Long> {
    Universite findByLibelle(String libelle);
    int deleteUniversiteById(long id);
}
