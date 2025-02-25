package com.example.gestionvoitureproprietairej2ee.dao;

import com.example.gestionvoitureproprietairej2ee.entities.Proprietaire;
import com.example.gestionvoitureproprietairej2ee.entities.Voiture;

import java.sql.SQLException;
import java.util.List;

public interface ProprietaireDAO extends GenericDao<Proprietaire, Integer>{
    public List<Voiture> getAllVoiture() throws SQLException;
}
