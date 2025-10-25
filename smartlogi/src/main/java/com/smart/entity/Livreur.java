package com.smart.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "livreurs", uniqueConstraints = @UniqueConstraint(columnNames = {"nom","telephone"}))
public class Livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String vehicule;
    private String telephone;

    @OneToMany(mappedBy = "livreur", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Colis> colis;

    // constructors
    public Livreur() {}
    public Livreur(String nom, String prenom, String vehicule, String telephone) {
        this.nom = nom; this.prenom = prenom; this.vehicule = vehicule; this.telephone = telephone;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getVehicule() { return vehicule; }
    public void setVehicule(String vehicule) { this.vehicule = vehicule; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public List<Colis> getColis() { return colis; }
    public void setColis(List<Colis> colis) { this.colis = colis; }

    @Override
    public String toString() {
        return "Livreur{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' +
                ", vehicule='" + vehicule + '\'' + ", telephone='" + telephone + '\'' + '}';
    }
}
