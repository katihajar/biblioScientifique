package com.example.demo.service;

import com.example.demo.document.Documents;
import com.example.demo.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentsService {
    @Autowired
    DocumentsRepository documentsRepository;

    public Documents findByTitre(String titre) {
        return documentsRepository.findByTitre(titre);
    }

    public List<Documents> findAll() {
        return documentsRepository.findAll();
    }

    public  Documents save(Documents entity) {
        return documentsRepository.save(entity);
    }
    @Transactional
    public int deleteListDocumentById(List<Documents> documentsList) {
        int res = 0;
        for (int i = 0; i < documentsList.size(); i++) {
            res += deleteDocumentById(documentsList.get(i).getId());
        }
        return res;
    }

    @Transactional
    public int deleteDocumentById(Long id) {
        int deleteByid= documentsRepository.deleteDocumentsById(id);
        return deleteByid;
    }
}
