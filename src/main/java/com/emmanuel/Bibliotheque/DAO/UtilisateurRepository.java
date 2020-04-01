package com.emmanuel.Bibliotheque.DAO;

import com.emmanuel.Bibliotheque.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    //Utilisateur findByIdUtilisateur();
    Utilisateur findById(int id);
}
