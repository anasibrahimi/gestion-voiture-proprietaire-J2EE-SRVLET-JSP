//package com.example.gestionvoitureproprietairej2ee;
//
//import com.example.gestionvoitureproprietairej2ee.dao.implementation.ProprietaireDaoImpl;
//import com.example.gestionvoitureproprietairej2ee.dao.GenericDao;
//import com.example.gestionvoitureproprietairej2ee.dao.implementation.VoitureDaoImpl;
//import com.example.gestionvoitureproprietairej2ee.entities.Proprietaire;
//import com.example.gestionvoitureproprietairej2ee.entities.Voiture;
//
//import java.sql.SQLException;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        GenericDao dao = new ProprietaireDaoImpl();
//        GenericDao dao1 = new VoitureDaoImpl();
//
//        // add des proprietaires
//        Proprietaire proprietaire1 = new Proprietaire();
//        proprietaire1.setNom("El Amrani");
//        proprietaire1.setPrenom("Ahmed");
//        proprietaire1.setCin("EE1234568");
//        dao.save(proprietaire1);
//        System.out.println("added succesfully");
//
//        Proprietaire proprietaire2 = new Proprietaire();
//        proprietaire2.setNom("Benjelloun");
//        proprietaire2.setPrenom("Yahya");
//        proprietaire2.setCin("EE1234565");
//        dao.save(proprietaire2);
//
//        Proprietaire proprietaire3 = new Proprietaire();
//        proprietaire3.setNom("Benjelloun");
//        proprietaire3.setPrenom("Mohamed");
//        proprietaire3.setCin("EE1234567");
//        dao.save(proprietaire3);
//
//
//        // add des voitures
//        Voiture voiture1 = new Voiture();
//        voiture1.setMarque("Mercedes");
//        voiture1.setModele("G class");
//        voiture1.setMatricule("2043 a 23");
//        voiture1.setProprietaire(proprietaire1);
//        dao1.save(voiture1);
//
//        Voiture voiture2 = new Voiture();
//        voiture2.setMarque("R205");
//        voiture2.setModele("Clio");
//        voiture2.setMatricule("2043 b 23");
//        voiture2.setProprietaire(proprietaire2);
//        dao1.save(voiture2);
//
//        //update prenom de proprietaire 3
//        proprietaire3.setNom("El-Karimi");
//        dao.update(proprietaire3);
//
//        //delete voiture 2 et proprietaire 2
//        dao1.delete(voiture2.getId());
//        dao.delete(proprietaire2.getId());
//
//        // affchiage la liste des proprietaires
//        dao.findAll().forEach(p -> System.out.println(p.toString()));
//
//        // affchiage la liste des voitures
//        dao1.findAll().forEach(v -> System.out.println(v.toString()));
//
//        Proprietaire proprietaire = (Proprietaire) dao.findById(proprietaire1.getId());
//        System.out.println(proprietaire.toString());
//
//        Voiture voiture = (Voiture) dao1.findById(voiture1.getId());
//        System.out.println(voiture.toString());
//    }
//}