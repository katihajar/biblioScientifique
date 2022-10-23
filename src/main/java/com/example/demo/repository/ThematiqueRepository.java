package com.example.demo.repository;

import com.example.demo.document.Thematique;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ThematiqueRepository extends MongoRepository<Thematique, Long> {
    Thematique findByDomaine(String domaine);
    int deleteThematiqueById(long id);
}
