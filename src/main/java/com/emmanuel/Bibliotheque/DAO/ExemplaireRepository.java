package com.emmanuel.Bibliotheque.DAO;

import com.emmanuel.Bibliotheque.model.Exemplaire;
import com.emmanuel.Bibliotheque.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {

    List<Exemplaire> findAllByUtilisateur(Utilisateur utilisateur);

  //  Exemplaire findById(int id);

}
