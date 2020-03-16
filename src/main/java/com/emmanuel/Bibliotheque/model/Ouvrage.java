package com.emmanuel.Bibliotheque.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Ouvrage implements Serializable {

    @Id
    @GeneratedValue
    private Integer idOuvrage;
    private String titre;
    private String auteur;
//    @OneToMany(mappedBy = "ouvrage")
//    private List<Exemplaire> exemplaires;

    public Ouvrage() {
    }

    public Integer getIdOuvrage() {
        return idOuvrage;
    }

    public void setIdOuvrage(Integer idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
/*

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
*/
}
