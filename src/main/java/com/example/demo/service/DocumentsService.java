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
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    public String addFile(MultipartFile upload) throws IOException {

        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());

        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);

        return fileID.toString();
    }


    public Documents downloadFile(Documents entity) throws IOException {

        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(entity.getId())) );

        Documents loadFile = new Documents();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            loadFile.setTitre( gridFSFile.getFilename() );

            loadFile.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

            loadFile.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

            loadFile.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
        }

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
    public int deleteDocumentById(Long id) {
        int deleteByid= documentsRepository.deleteDocumentsById(id);
        return deleteByid;
    }
}
