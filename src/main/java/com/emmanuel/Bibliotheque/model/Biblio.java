package com.emmanuel.Bibliotheque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Biblio implements Serializable {
    @Id
    @GeneratedValue
    private Integer idBiblio;
    private String nomBiblio;
    @OneToMany(mappedBy = "biblio")
    private List<Exemplaire> exemplaires;

    public Biblio() {
    }

    public Integer getIdBiblio() {
        return idBiblio;
    }

    public void setIdBiblio(Integer idBiblio) {
        this.idBiblio = idBiblio;
    }

    public String getNomBiblio() {
        return nomBiblio;
    }

    public void setNomBiblio(String nomBiblio) {
        this.nomBiblio = nomBiblio;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
