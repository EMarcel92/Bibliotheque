package com.emmanuel.Bibliotheque.controller;
import com.emmanuel.Bibliotheque.DAO.ExemplaireRepository;
import com.emmanuel.Bibliotheque.DAO.OuvrageRepository;
import com.emmanuel.Bibliotheque.DAO.UtilisateurRepository;
import com.emmanuel.Bibliotheque.DTO.OuvrageDTO;
import com.emmanuel.Bibliotheque.exception.PretIntrouvableException;
import com.emmanuel.Bibliotheque.exception.UtilisateurInconnuException;
import com.emmanuel.Bibliotheque.model.Exemplaire;
import com.emmanuel.Bibliotheque.model.Ouvrage;
import com.emmanuel.Bibliotheque.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {

    @Autowired
    private OuvrageRepository ouvrageRepository;
    private ExemplaireRepository exemplaireRepository;
    private UtilisateurRepository utilisateurRepository;

    @GetMapping(value="/livres")
    public List<Ouvrage> listeLivres (){
        //return exemplaireDAO.findAll();
        return ouvrageRepository.findAll();
    }

//    @GetMapping("/livresdispo")
//    public List<OuvrageDTO> listeLivres1 (){
//        return ouvrageRepository.listeOuvragesDispo();
//    }

    @GetMapping("/livr/{id}")
    public Ouvrage afficherUnSite(@PathVariable Integer id) {
        Optional<Ouvrage> ouvrage = ouvrageRepository.findById(id);
        return ouvrage.isPresent()?ouvrage.get():null;
    }

    @GetMapping("/liv/{id}")
    public Exemplaire boubou (@PathVariable Integer id) {
        Optional<Exemplaire> exemplaire = exemplaireRepository.findById(id);
        return exemplaire.isPresent()?exemplaire.get():null;
    }

    @GetMapping("/livre/{id}")
    public Exemplaire rechercherUnExemplaire(@PathVariable("id") Integer id) {
        Optional<Exemplaire> exemplaire = exemplaireRepository.findById(id);
        return exemplaire.isPresent()?exemplaire.get():null;
    }

    @GetMapping("/prets/{id}")
    public List<Exemplaire> listePretsDunUtilisateur(@PathVariable("id") Integer id) {
        Optional<Exemplaire> exemplaire = exemplaireRepository.findById(1);
        Utilisateur utilisateur = utilisateurRepository.findById(1);
//                .orElseThrow(() -> new UtilisateurInconnuException("L'utilisateur d'identifiant " + id + " est inconnu."));

      //  Optional<Utilisateur> utilisateur2 = utilisateurRepository.findById(id);

        if (utilisateur== null) {
            List<Exemplaire> emprunts = exemplaireRepository.findAllByUtilisateur(utilisateur);
            if (emprunts.isEmpty())
                throw new PretIntrouvableException("Aucun prêt trouvé pour l'utilisateur d'identifiant " + id + ".");
            else
                return emprunts;
        }
        else
            throw new UtilisateurInconnuException("L'utilisateur d'identifiant " + id + " est inconnu.");
    }
}

