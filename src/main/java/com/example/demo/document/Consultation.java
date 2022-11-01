package com.example.demo.document;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Consultation {
    @Id
    String id;
    private double nbrConsultation;
    private double nbrTelechargement;
    @NonNull
    @DBRef
    private User user;
    @NonNull
    @DBRef
    private Documents documents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getNbrConsultation() {
        return nbrConsultation;
    }

    public void setNbrConsultation(double nbrConsultation) {
        this.nbrConsultation = nbrConsultation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public double getNbrTelechargement() {
        return nbrTelechargement;
    }

    public void setNbrTelechargement(double nbrTelechargement) {
        this.nbrTelechargement = nbrTelechargement;
    }
}
