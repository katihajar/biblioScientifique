package com.example.demo.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
@Data
public class Documents{
    @Id
    Long id;
    private String titre;
    private double nmbrTelechargement;
    private boolean statut;
    private Date datePubl;
    private Thematique thematique;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


}
