package com.example.gestionvoitureproprietairej2ee.entities;

public class Proprietaire {

    private Integer id ;
    private String nom ;
    private String prenom ;
    private String cin ;


    public Proprietaire( String nom, String prenom, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }

    public Proprietaire() {
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Proprietaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                '}';
    }
}
