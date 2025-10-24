package com.smart;

import com.smart.entity.Colis;
import com.smart.entity.Livreur;
import com.smart.service.ColisService;
import com.smart.service.LivreurService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context =
                new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");

        LivreurService livreurService = context.getBean("livreurService", LivreurService.class);
        ColisService colisService = context.getBean("colisService", ColisService.class);

        // ================== TEST LIVREUR ==================
        Livreur livreur1 = new Livreur();
        livreur1.setNom("oum");
        livreur1.setPrenom("imane");
        livreur1.setVehicule("Moto");
        livreur1.setTelephone("0429474794");

        // Sauvegarde du livreur
        livreurService.saveLivreur(livreur1);
        System.out.println("Livreur ajouté avec succès !");

        // ================== TEST COLIS ==================
        Colis colis1 = new Colis();
        colis1.setDestinataire("Karima El Amrani");
        colis1.setAdresse("settat, Maarif");
        colis1.setPoids(2.5);
        colis1.setStatut("Préparation");
        colis1.setLivreur(livreur1);

        System.out.println(colis1);

        // Sauvegarde du colis
        colisService.saveColis(colis1);
        System.out.println("Colis ajouté avec succès !");

        // ================== LISTER LES COLIS ==================
        System.out.println("Liste des colis :");
        colisService.getAllColis().forEach(System.out::println);

        // ================== MISE À JOUR STATUT ==================
        colis1.setStatut("Livré");
        colisService.saveColis(colis1);
        System.out.println("Statut du colis mis à jour !");

        // ================== SUPPRESSION ==================
        //colisService.deleteColis(colis1.getId());
        //System.out.println("Colis supprimé !");
    }
}