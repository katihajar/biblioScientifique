package com.example.demo.service;

import com.example.demo.document.Consultation;
import com.example.demo.document.Documents;
import com.example.demo.document.Thematique;
import com.example.demo.document.User;
import com.example.demo.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    ConsultationRepository consultationRepository;
    @Autowired
    UserService userService;
    @Autowired
    DocumentsService documentsService;

    public List<Consultation> findByDocumentsTitre(String titre) {
        return consultationRepository.findByDocumentsTitre(titre);
    }

    public List<Consultation> findByUserUsername(String username) {
        return consultationRepository.findByUserUsername(username);
    }

    public Consultation findConsultationById(String id) {
        return consultationRepository.findConsultationById(id);
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public Consultation save(Consultation entity) {
        User user = userService.findById(entity.getUser().getId());
        Documents doc = documentsService.findDocumentById(entity.getDocuments().getId());
        entity.setUser(user);
        entity.setDocuments(doc);

        return consultationRepository.save(entity);
    }
}
