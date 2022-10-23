package com.example.demo.document;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Consultation")
@Data
public class Consultation {
    @Id
    Long id;
    private double nbrConsultation;
    private double nbrTelechargement;
    @NonNull
    private User user;
    @NonNull
    private Documents documents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
