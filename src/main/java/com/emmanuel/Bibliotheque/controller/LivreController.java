package com.emmanuel.Bibliotheque.controller;
import com.emmanuel.Bibliotheque.DAO.ExemplaireDAO;
import com.emmanuel.Bibliotheque.model.Exemplaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {

    @Autowired
   // private OuvrageDAO ouvrageDAO;
    private ExemplaireDAO exemplaireDAO;

    @GetMapping(value="/livres")
    public List<Exemplaire> listeLivres (){
        return exemplaireDAO.findAll();
    }

    @GetMapping(value = "/livre/{id}")
    public Optional<Exemplaire> rechercherUnExemplaire(@PathVariable int id) {
        return exemplaireDAO.findById(id);
    }
}

