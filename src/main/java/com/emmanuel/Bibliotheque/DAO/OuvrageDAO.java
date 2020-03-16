package com.emmanuel.Bibliotheque.DAO;

import com.emmanuel.Bibliotheque.model.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OuvrageDAO extends JpaRepository<Ouvrage, Integer> {

}
