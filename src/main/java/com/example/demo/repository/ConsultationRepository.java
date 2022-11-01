package com.example.demo.repository;

import com.example.demo.document.Consultation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultationRepository extends MongoRepository<Consultation, String> {
    Consultation findConsultationById(String id);
    List<Consultation> findByDocumentsTitre(String titre);
    List<Consultation> findByUserUsername(String username);
}
