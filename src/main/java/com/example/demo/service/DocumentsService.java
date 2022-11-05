package com.example.demo.service;

import com.example.demo.document.Documents;
import com.example.demo.repository.DocumentsRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentsService {
    @Autowired
    DocumentsRepository documentsRepository;
    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;
    public Documents findByTitre(String titre) {
        return documentsRepository.findByTitre(titre);
    }

    public List<Documents> findAll() {
        return documentsRepository.findAll();
    }


    public Documents addFile(MultipartFile upload,Documents doc) throws IOException {

        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());

        //Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
        Documents documents = new Documents();
        documents.setFile(upload.getBytes());
        documents.setTitre(upload.getOriginalFilename());
        documents.setFileSize(upload.getSize());
        documents.setFileType(upload.getContentType());
        documents.setStatut(doc.getStatut());
        documents.setDatePubl(new Date());
        documents.setNmbrTelechargement(0);
        documents.setUser(doc.getUser());
        documents.setThematique(doc.getThematique());
        return documentsRepository.save(documents);
    }


    public Documents getFile(String id){

        Documents loadFile= documentsRepository.findDocumentById(id);
        return loadFile;
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
    public int deleteDocumentById(String id) {
        int deleteByid= documentsRepository.deleteDocumentsById(id);
        return deleteByid;
    }

    public Documents changeStatus(String id,Boolean status) {
        Documents doc = documentsRepository.findDocumentById(id);
        doc.setStatut(status);
        return documentsRepository.save(doc);
    }

    public Documents findDocumentById(String id) {
        return documentsRepository.findDocumentById(id);
    }
}
