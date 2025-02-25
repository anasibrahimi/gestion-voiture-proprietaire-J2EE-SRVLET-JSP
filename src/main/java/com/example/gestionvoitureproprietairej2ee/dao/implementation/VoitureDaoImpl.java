package com.example.gestionvoitureproprietairej2ee.dao.implementation;

import com.example.gestionvoitureproprietairej2ee.config.MyConnection;
import com.example.gestionvoitureproprietairej2ee.dao.GenericDao;
import com.example.gestionvoitureproprietairej2ee.dao.VoitureDAO;
import com.example.gestionvoitureproprietairej2ee.entities.Proprietaire;
import com.example.gestionvoitureproprietairej2ee.entities.Voiture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VoitureDaoImpl implements VoitureDAO {
    Connection connection = MyConnection.getConnection();
     PreparedStatement ps ;
     GenericDao dao = new ProprietaireDaoImpl();

    @Override
    public Voiture save(Voiture voiture) throws SQLException {
        try {
            ps = connection.prepareStatement(
                    "INSERT INTO voiture (marque,modele,matricule,proprietaire_id) values (?,?,?,?)"
                    ,ps.RETURN_GENERATED_KEYS);
            ps.setString(1,voiture.getMarque());
            ps.setString(2,voiture.getModele());
            ps.setString(3,voiture.getMatricule());
            ps.setInt(4,voiture.getProprietaire().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                voiture.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return voiture;
    }
    @Override
    public Voiture update(Voiture voiture) throws SQLException {
        ps = connection.prepareStatement
                ("update voiture set marque = ?, modele = ?, matricule = ?,proprietaire_id = ? where id = ?");

        ps.setString(1,voiture.getMarque());
        ps.setString(2,voiture.getModele());
        ps.setString(3,voiture.getMatricule());
        ps.setInt(4,voiture.getProprietaire().getId());
        ps.setInt(5,voiture.getId());
        ps.executeUpdate();
        return voiture;
    }
    @Override
    public void delete(Integer id) throws SQLException {
        ps = connection.prepareStatement("delete from voiture where id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
    }
    @Override
    public Voiture findById(Integer id) throws SQLException {
        Voiture voiture = new Voiture();
        ps = connection.prepareStatement("SELECT * from voiture where id = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            voiture.setId(rs.getInt(1));
            voiture.setMarque(rs.getString(2));
            voiture.setModele(rs.getString(3));
            voiture.setMatricule(rs.getString(4));
            Proprietaire proprietaire = (Proprietaire) dao.findById(rs.getInt(5));
            voiture.setProprietaire(proprietaire);
        }
        return voiture;
    }
    @Override
    public Collection<Voiture> findAll() throws SQLException {
        List<Voiture> voitureList = new ArrayList<>();
        ps = connection.prepareStatement("select * from  voiture");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            Voiture voiture = new Voiture();
            voiture.setId(resultSet.getInt(1));
            voiture.setMarque(resultSet.getString(2));
            voiture.setModele(resultSet.getString(3));
            voiture.setMatricule(resultSet.getString(4));
            Proprietaire proprietaire  = (Proprietaire) dao.findById(resultSet.getInt(5));
            voiture.setProprietaire(proprietaire);
            voitureList.add(voiture);
        }
        return voitureList;
    }


    @Override
    public List<Proprietaire> getAllProprietaires(Integer voiture_id) {
        return List.of();
    }
}
