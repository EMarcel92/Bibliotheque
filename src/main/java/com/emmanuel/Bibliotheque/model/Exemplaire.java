package com.emmanuel.Bibliotheque.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Exemplaire implements Serializable {
    @Id
    @GeneratedValue
    private Integer idExemplaire;
    private Integer codeBarre;
    private Date dateRetour;
    private Boolean Prolongation;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_ouvrage", nullable=false)
    private Ouvrage ouvrage;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_biblio", nullable=false)
    private Biblio biblio;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur") //, nullable=true)
    private Utilisateur utilisateur;

    public Exemplaire() {
    }

    public Integer getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(Integer idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Boolean getProlongation() {
        return Prolongation;
    }

    public void setProlongation(Boolean prolongation) {
        Prolongation = prolongation;
    }

    public Integer getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(Integer codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Biblio getBiblio() {
        return biblio;
    }

    public void setBiblio(Biblio biblio) {
        this.biblio = biblio;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
