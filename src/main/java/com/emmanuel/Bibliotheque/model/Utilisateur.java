package com.emmanuel.Bibliotheque.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //génère une nouvelle valeur à chaque entité commitée
    private Integer idUtilisateur;
    @NotBlank(message = "Pseudo obligatoire")
    @NotNull
    @Size(min = 3, max = 10, message = "Le pseudo doit avoir 3 à 10 caractères")
    @Column(unique = true)
    private String pseudo;
    @NotNull
    @Column(nullable = false)
    private String motDePasse;
    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "Nom de 2 à 50 caractères")
    private String nomUtilisateur;
    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "Prénom de 2 à 50 caractères")
    private String prenomUtilisateur;
    @Column(nullable = false)
    private String email;

    @Transient
    private String motDePasseConfirme;

    /*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utilisateur_role", joinColumns = @JoinColumn(name = "utilisateurid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Collection<Role> roles;
*/
    @JsonBackReference
    @OneToMany(mappedBy="utilisateur", cascade = CascadeType.ALL)
    private List<Exemplaire> exemplaires;

    public Utilisateur() {
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasseConfirme() {
        return motDePasseConfirme;
    }

    public void setMotDePasseConfirme(String motDePasseConfirme) {
        this.motDePasseConfirme = motDePasseConfirme;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
