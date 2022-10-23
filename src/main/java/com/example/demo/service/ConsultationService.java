package com.example.demo.service;

import com.example.demo.document.Consultation;
import com.example.demo.document.Thematique;
import com.example.demo.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    ConsultationRepository consultationRepository;

    public List<Consultation> findByDocumentsTitre(String titre) {
        return consultationRepository.findByDocumentsTitre(titre);
    }

    public List<Consultation> findByUserUsername(String username) {
        return consultationRepository.findByUserUsername(username);
    }

    public Consultation findConsultationById(Long id) {
        return consultationRepository.findConsultationById(id);
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public Consultation save(Consultation entity) {
        return consultationRepository.save(entity);
    }
}
