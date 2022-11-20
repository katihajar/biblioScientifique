package com.example.demo.repository;

import com.example.demo.document.Documents;
import com.example.demo.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepository extends MongoRepository<Documents, String> {
    Documents findByTitre(String titre);
    Documents findDocumentById(String id);
    List<Documents> findByUser(User user);
    List<Documents> findByVisibiliteAndStatut(boolean vs,boolean statut);
    int deleteDocumentsById(String id);
}
