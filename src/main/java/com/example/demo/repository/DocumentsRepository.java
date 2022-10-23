package com.example.demo.repository;

import com.example.demo.document.Documents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends MongoRepository<Documents, Long> {
    Documents findByTitre(String titre);
    int deleteDocumentsById(long id);
}
