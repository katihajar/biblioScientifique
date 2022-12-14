package com.example.demo.service;

import com.example.demo.document.Documents;
import com.example.demo.document.Thematique;
import com.example.demo.document.User;
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
import javax.swing.text.Document;
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
    UserService userService;
    @Autowired
    ThematiqueService thematiqueService;
    @Autowired
    private GridFsOperations operations;
    public Documents findByTitre(String titre) {
        return documentsRepository.findByTitre(titre);
    }

    public List<Documents> findAll() {
        return documentsRepository.findAll();
    }

    public List<Documents> findByVisibiliteAndStatut(boolean vs, boolean statut) {
        return documentsRepository.findByVisibiliteAndStatut(vs, statut);
    }

    public List<Documents> findByStatut(boolean statut) {
        return documentsRepository.findByStatut(statut);
    }

    public Documents addFile(MultipartFile upload, Boolean vs, String user, String them, String type, Date dat) throws IOException {
        User us= userService.findUserById(user);
        Thematique th = thematiqueService.findThematiqueById(them);
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());
        Documents documents = new Documents();
        documents.setFile(upload.getBytes());
        documents.setTitre(upload.getOriginalFilename());
        documents.setFileSize(upload.getSize());
        documents.setFileType(upload.getContentType());
        documents.setStatut(false);
        documents.setDatePubl(new Date());
        documents.setNmbrTelechargement(0);
        documents.setNmbrVue(0);
        documents.setVisibilite(vs);
        documents.setUser(us);
        documents.setThematique(th);
        documents.setTypeDoc(type);
        documents.setDateDoc(dat);
        return documentsRepository.save(documents);
    }
    public  Documents countView(String id){
        Documents doc1= findDocumentById(id);
        doc1.setNmbrVue(doc1.getNmbrVue()+1);
        return documentsRepository.save(doc1);
    }
    public Documents update(Documents doc){
        Documents doc1= findDocumentById(doc.getId());
        doc1.setVisibilite(doc.isVisibilite());
        doc1.setUser(doc.getUser());
        doc1.setThematique(doc.getThematique());
        return documentsRepository.save(doc1);
    }

    public List<Documents> findByUserId(String id) {
        User user = userService.findById(id);
        return documentsRepository.findByUser(user);
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

    public Documents changeVisib(String id,Boolean vs) {
        Documents doc = documentsRepository.findDocumentById(id);
        doc.setVisibilite(vs);
        return documentsRepository.save(doc);
    }
    public Documents changeStatus(String id,Boolean vs) {
        Documents doc = documentsRepository.findDocumentById(id);
        doc.setStatut(vs);
        return documentsRepository.save(doc);
    }
    public Documents save1(Documents entity) {
        return documentsRepository.save(entity);
    }

    public Documents findDocumentById(String id) {
        return documentsRepository.findDocumentById(id);
    }


    public Documents editFile(MultipartFile upload,  String user, String them,String type,Date dat,String id) throws IOException {
        Documents doc = findDocumentById(id);
        User us= userService.findUserById(user);
        Thematique th = thematiqueService.findThematiqueById(them);
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());
        doc.setFile(upload.getBytes());
        doc.setTitre(upload.getOriginalFilename());
        doc.setFileSize(upload.getSize());
        doc.setFileType(upload.getContentType());
        doc.setStatut(false);
        doc.setDatePubl(new Date());
        doc.setNmbrTelechargement(0);
        doc.setNmbrVue(0);
        doc.setUser(us);
        doc.setThematique(th);
        doc.setTypeDoc(type);
        doc.setDateDoc(dat);
        return documentsRepository.save(doc);
    }

}
