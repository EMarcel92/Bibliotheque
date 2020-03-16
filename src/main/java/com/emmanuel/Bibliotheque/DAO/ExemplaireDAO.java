package com.emmanuel.Bibliotheque.DAO;

import com.emmanuel.Bibliotheque.model.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplaireDAO extends JpaRepository<Exemplaire, Integer> {

}
