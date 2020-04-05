package com.emmanuel.Bibliotheque.controller;
import com.emmanuel.Bibliotheque.DAO.ExemplaireRepository;
import com.emmanuel.Bibliotheque.DAO.OuvrageRepository;
import com.emmanuel.Bibliotheque.DAO.UtilisateurRepository;
import com.emmanuel.Bibliotheque.DTO.RequetePret;
import com.emmanuel.Bibliotheque.DTO.OuvrageDTO;
import com.emmanuel.Bibliotheque.DTO.RequeteProlongation;
import com.emmanuel.Bibliotheque.exception.*;
import com.emmanuel.Bibliotheque.model.Exemplaire;
import com.emmanuel.Bibliotheque.model.Ouvrage;
import com.emmanuel.Bibliotheque.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PretsController {

    @Autowired
    private OuvrageRepository ouvrageRepository;
    @Autowired
    private ExemplaireRepository exemplaireRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    //Utilisé uniquement pour des tests
    @GetMapping(value="/livres")
    public List<Ouvrage> listeLivres (){
        return ouvrageRepository.findAll();
    }

    /**
     * recherche la liste des livres disponibles pour un prêt
     * @return liste d'ouvrage avec nombre d'exemplaires disponible dans chaque bibliothèque
     */
    @GetMapping("/livresdispo")
    public List<OuvrageDTO> listeLivres1 (){
        return ouvrageRepository.listeOuvragesDispo();
    }

    /**
     * Recherche les exemplaires d'ouvrages empruntés par un utilisateur
     * @param id id de l'utilisateur
     * @return liste des exemplaires en prêt
     */
    @GetMapping("/prets/{id}")
    public List<Exemplaire> listePretsDunUtilisateur(@PathVariable("id") Integer id) {
        //Optional<Exemplaire> exemplaire = exemplaireRepository.findById(id);
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new UtilisateurInconnuException("L'utilisateur d'identifiant " + id + " est inconnu."));

        List<Exemplaire> emprunts = exemplaireRepository.findAllByUtilisateur(utilisateur);

        if (emprunts.isEmpty())
            throw new PretIntrouvableException("Aucun prêt trouvé pour l'utilisateur d'identifiant " + id + ".");
        else
            return emprunts;
    }

    @GetMapping("/livresnonrendus")
    public List<Exemplaire> listeLivresNonrendus(){
        Date aujourdhui = Calendar.getInstance().getTime();
        List<Exemplaire> livresNonRendus = exemplaireRepository.findAllByDateRetourLessThan(aujourdhui);
        return livresNonRendus;
    }

    @GetMapping("/livre/{id}")
    public Exemplaire boubou (@PathVariable Integer id) {
        Optional<Exemplaire> exemplaire = exemplaireRepository.findById(id);
        return exemplaire.isPresent()?exemplaire.get():null;
    }

    @PostMapping(value = "/pret")
    public void creerUnPret(@RequestBody RequetePret requetePret) {
        Exemplaire exemplaire = exemplaireRepository.findById(requetePret.getIdExemplaire())
                .orElseThrow(() -> new ExemplaireInconnuException("Le livre d'identifiant " + requetePret.getIdExemplaire() + " est inconnu."));

        if (exemplaire.getUtilisateur() == null){  // Pas de prêt en cours
            Utilisateur utilisateur = utilisateurRepository.findById(requetePret.getIdUtilisateur())
                    .orElseThrow(() -> new UtilisateurInconnuException("L'utilisateur d'identifiant " + requetePret.getIdUtilisateur() + " est inconnu."));
            exemplaire.setUtilisateur(utilisateur);
            exemplaire.setDateRetour(dateDeRetour(new Date(), 28));
            exemplaireRepository.save(exemplaire);
        }
        else{
            throw new ExemplaireDejaPreteException("Le livre d'identifiant " + requetePret.getIdExemplaire() + " est déjà prêté.");
        }
    }

    @PostMapping(value = "/prolongation")
    public void prolongerUnPret(@RequestBody RequeteProlongation requeteProlongation) {
        Exemplaire exemplaire = exemplaireRepository.findById(requeteProlongation.getIdExemplaire())
                .orElseThrow(() -> new ExemplaireInconnuException("Le livre d'identifiant " + requeteProlongation.getIdExemplaire() + " est inconnu."));

        if (exemplaire.getProlongation() == false){  // Pas de prolongation engagée
            exemplaire.setDateRetour(dateDeRetour(exemplaire.getDateRetour(), 28));
            exemplaireRepository.save(exemplaire);
        }
        else{
            throw new PretDejaProlongeException("La durée de prêt du livre " + exemplaire.getIdExemplaire() + " a déjà été prolongée.");
        }
    }

    @PostMapping(value = "/retour")
    public void retournerUnPret(@RequestBody RequeteProlongation requeteProlongation) {
        Exemplaire exemplaire = exemplaireRepository.findById(requeteProlongation.getIdExemplaire())
                .orElseThrow(() -> new ExemplaireInconnuException("Le livre d'identifiant " + requeteProlongation.getIdExemplaire() + " est inconnu."));

        exemplaire.setDateRetour(null);
        exemplaire.setUtilisateur(null);
        exemplaireRepository.save(exemplaire);
    }

    private static Date dateDeRetour(Date date, int nbJour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println( "!!!!!!!! date en entrée : " + cal);
        cal.add(Calendar.DATE, nbJour);
        System.out.println( "!!!!!!!! date en sortie : " + cal);
        return cal.getTime();
    }

}
