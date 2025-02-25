package com.example.gestionvoitureproprietairej2ee.dao.implementation;

import com.example.gestionvoitureproprietairej2ee.config.MyConnection;
import com.example.gestionvoitureproprietairej2ee.dao.ProprietaireDAO;
import com.example.gestionvoitureproprietairej2ee.entities.Proprietaire;
import com.example.gestionvoitureproprietairej2ee.entities.Voiture;

import java.sql.*;
import java.util.*;

public class ProprietaireDaoImpl implements ProprietaireDAO {
    Connection con =  MyConnection.getConnection();
    PreparedStatement ps ;

    @Override
    public Proprietaire save(Proprietaire proprietaire) throws SQLException {

            ps = con.prepareStatement
                    ("INSERT INTO proprietaire (nom, prenom, cin) VALUES (?,?,?)"
                            , ps.RETURN_GENERATED_KEYS);
            ps.setString(1, proprietaire.getNom());
            ps.setString(2, proprietaire.getPrenom());
            ps.setString(3, proprietaire.getCin());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                proprietaire.setId(rs.getInt(1));
            }
            return proprietaire;
    }
    @Override
    public Proprietaire update(Proprietaire proprietaire) throws SQLException {
        ps = con.prepareStatement("Update proprietaire set nom = ?, prenom = ?, cin = ? where id = ?");
        ps.setString(1, proprietaire.getNom());
        ps.setString(2, proprietaire.getPrenom());
        ps.setString(3, proprietaire.getCin());
        ps.setInt(4, proprietaire.getId());
        ps.executeUpdate();
        return proprietaire;
    }


    @Override
    public void delete(Integer id) throws SQLException {
        ps= con.prepareStatement("DELETE FROM voiture WHERE proprietaire_id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        ps= con.prepareStatement("delete from proprietaire where id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public Proprietaire findById(Integer id) throws SQLException {
        ps = con.prepareStatement("SELECT * FROM proprietaire WHERE id = ?");
        ps.setInt(1,id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            Proprietaire proprietaire = new Proprietaire();
            proprietaire.setId(id);
            proprietaire.setNom(resultSet.getString(2));
            proprietaire.setPrenom(resultSet.getString(3));
            proprietaire.setCin(resultSet.getString(4));
            return proprietaire;
        }
        return null;
    }
    @Override
    public Collection<Proprietaire> findAll() throws SQLException {
        List<Proprietaire> allProprietaires = new ArrayList<>();
        ps = con.prepareStatement("select * from proprietaire");
        ResultSet resultSet = ps.executeQuery();
       while (resultSet.next()){
           Proprietaire proprietaire = new Proprietaire();
           proprietaire.setId(resultSet.getInt(1));
           proprietaire.setNom(resultSet.getString(2));
              proprietaire.setPrenom(resultSet.getString(3));
              proprietaire.setCin(resultSet.getString(4));
              allProprietaires.add(proprietaire);
        }
        return allProprietaires;
    }

    @Override
    public List<Voiture> getAllVoiture() throws SQLException {
        List<Voiture> voitureList = new ArrayList<>();
        ps = con.prepareStatement("select ");
        return List.of();
    }
}
