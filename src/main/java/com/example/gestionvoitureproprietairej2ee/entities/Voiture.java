package com.example.gestionvoitureproprietairej2ee.entities;

public class Voiture {

    private int id ;
    private String marque ;
    private String modele ;
    private String matricule ;
    private Proprietaire proprietaire ;

    public Voiture() {
    }



    public Voiture(int id, String marque, String modele, String matricule) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
    }

    public Voiture(String marque, String modele, String matricule, Proprietaire proprietaire) {
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
        this.proprietaire = proprietaire;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", matricule='" + matricule + '\'' +
                ", proprietaire=" + proprietaire.toString() +
                '}';
    }
}
