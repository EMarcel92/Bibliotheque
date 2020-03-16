package com.emmanuel.Bibliotheque.model;

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
    @OneToMany(mappedBy="utilisateur", cascade = CascadeType.ALL)
    private List<Exemplaire> exemplaires;

}
