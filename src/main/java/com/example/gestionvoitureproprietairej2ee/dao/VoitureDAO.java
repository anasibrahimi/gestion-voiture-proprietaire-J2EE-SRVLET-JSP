package com.example.gestionvoitureproprietairej2ee.dao;

import com.example.gestionvoitureproprietairej2ee.entities.Proprietaire;
import com.example.gestionvoitureproprietairej2ee.entities.Voiture;

import java.util.List;

public interface VoitureDAO extends GenericDao<Voiture,Integer> {
    public List<Proprietaire> getAllProprietaires(Integer voiture_id);
}
