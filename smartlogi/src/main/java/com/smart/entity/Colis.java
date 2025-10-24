package com.smart.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "colis")
public class Colis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinataire;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private Double poids;

    @Column(nullable = false)
    private String statut; // Ex: "Préparation", "En transit", "Livré"

    // Relation ManyToOne avec Livreur
    @ManyToOne()
    @JoinColumn(name = "livreur_id")
    private Livreur livreur;

    // Constructeurs
    public Colis() { }

    public Colis(String destinataire, String adresse, Double poids, String statut, Livreur livreur) {
        this.destinataire = destinataire;
        this.adresse = adresse;
        this.poids = poids;
        this.statut = statut;
        this.livreur = livreur;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDestinataire() { return destinataire; }

    public void setDestinataire(String destinataire) { this.destinataire = destinataire; }

    public String getAdresse() { return adresse; }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public Double getPoids() { return poids; }

    public void setPoids(Double poids) { this.poids = poids; }

    public String getStatut() { return statut; }

    public void setStatut(String statut) { this.statut = statut; }

    public Livreur getLivreur() { return livreur; }

    public void setLivreur(Livreur livreur) { this.livreur = livreur; }

    @Override
    public String toString() {
        return "Colis{" +
                "id=" + id +
                ", destinataire='" + destinataire + '\'' +
                ", adresse='" + adresse + '\'' +
                ", poids=" + poids +
                ", statut='" + statut + '\'' +
                ", livreur=" + (livreur != null ? livreur.getId() : null) +
                '}';
    }
}
