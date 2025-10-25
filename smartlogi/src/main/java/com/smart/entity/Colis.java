package com.smart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="colis")
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinataire;
    private String adresse;
    private Double poids;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "livreur_id")
    @JsonBackReference
    private Livreur livreur;

    public enum Statut { PREPARATION, EN_TRANSIT, LIVRE }

    public Colis() {}
    public Colis(String destinataire, String adresse, Double poids, Statut statut) {
        this.destinataire = destinataire;
        this.adresse = adresse;
        this.poids = poids;
        this.statut = statut;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDestinataire() { return destinataire; }
    public void setDestinataire(String destinataire) { this.destinataire = destinataire; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public Double getPoids() { return poids; }
    public void setPoids(Double poids) { this.poids = poids; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }

    public Livreur getLivreur() { return livreur; }
    public void setLivreur(Livreur livreur) { this.livreur = livreur; }

    @Override
    public String toString() {
        return "Colis{" + "id=" + id + ", destinataire='" + destinataire + '\'' +
                ", adresse='" + adresse + '\'' + ", poids=" + poids + ", statut=" + statut + '}';
    }
}
