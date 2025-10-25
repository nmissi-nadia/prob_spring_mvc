package com.smart;

import com.smart.entity.Colis;
import com.smart.entity.Livreur;
import com.smart.service.ColisService;
import com.smart.service.LivreurService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try (var ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            LivreurService livreurService = ctx.getBean("livreurService", LivreurService.class);
            ColisService colisService = ctx.getBean("colisService", ColisService.class);

            // Create livreurs
            Livreur l1 = new Livreur("El", "Amin", "Moto", "060000001");
            Livreur l2 = new Livreur("Saad", "Omar", "Voiture", "060000002");
            l1 = livreurService.create(l1);
            l2 = livreurService.create(l2);
            System.out.println("Livreurs: " + livreurService.findAll());

            // Create colis and assign
            Colis c1 = new Colis("Youssef", "Rabat, rue A", 2.5, Colis.Statut.PREPARATION);
            Colis saved = colisService.create(c1, l1.getId());
            System.out.println("Colis créé: " + saved);

            // Change statut
            colisService.changeStatut(saved.getId(), Colis.Statut.EN_TRANSIT);
            System.out.println("Après statut: " + colisService.findById(saved.getId()).get());

            // List colis for livreur
            List<Colis> colisLivreur = colisService.findByLivreur(l1);
            System.out.println("Colis pour livreur " + l1.getId() + " : " + colisLivreur);

            // cleanup
            // livreurService.delete(l2.getId());
        }
    }
}
