package com.emmanuel.Bibliotheque.DAO;

import com.emmanuel.Bibliotheque.DTO.OuvrageDTO;
import com.emmanuel.Bibliotheque.model.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer> {

    @Query(value = "select o.titre as titre, o.auteur as auteur , COUNT(id_exemplaire) as nbexemplaires, b.nom_biblio as nombiblio " +
            "from exemplaire e inner join ouvrage o on e.id_ouvrage = o.id_ouvrage inner join biblio b on e.id_biblio = b.id_biblio " +
            "where e.id_utilisateur is null " +
            "GROUP BY o.id_ouvrage, b.nom_biblio", nativeQuery = true)
    List<OuvrageDTO> listeOuvragesDispo();

}
