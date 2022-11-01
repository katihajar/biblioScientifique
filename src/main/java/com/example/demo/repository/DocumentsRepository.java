package com.example.demo.repository;

import com.example.demo.document.Documents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends MongoRepository<Documents, String> {
    Documents findByTitre(String titre);
    Documents findDocumentById(String id);
    int deleteDocumentsById(String id);
}
