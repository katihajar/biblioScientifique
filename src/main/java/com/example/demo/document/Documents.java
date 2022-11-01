package com.example.demo.document;


import com.mongodb.DBObject;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;
import java.util.Date;

@Document
@Data
public class Documents{

    @Id
    String id;
    private String titre;
    private double nmbrTelechargement;
    private boolean statut;
    private Date datePubl;
    @DBRef
    private Thematique thematique;
    private String fileType;
    private long fileSize;
    private byte[] file;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getNmbrTelechargement() {
        return nmbrTelechargement;
    }

    public void setNmbrTelechargement(double nmbrTelechargement) {
        this.nmbrTelechargement = nmbrTelechargement;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Date getDatePubl() {
        return datePubl;
    }

    public void setDatePubl(Date datePubl) {
        this.datePubl = datePubl;
    }

    public Thematique getThematique() {
        return thematique;
    }

    public void setThematique(Thematique thematique) {
        this.thematique = thematique;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
