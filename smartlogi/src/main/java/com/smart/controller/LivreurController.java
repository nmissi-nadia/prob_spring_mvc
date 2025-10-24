package com.smart.controller;

import com.smart.entity.Livreur;
import com.smart.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livreurs")
public class LivreurController {

    private LivreurService livreurService;

    public LivreurController(LivreurService livreurService){
        this.livreurService = livreurService ;
    }

    // GET: afficher tous les livreurs
    @GetMapping
    public List<Livreur> getAllLivreurs() {
        return livreurService.getAllLivreurs();
    }

    // POST: ajouter un livreur
    @PostMapping
    public Livreur addLivreur(@RequestBody Livreur livreur) {
        return livreurService.saveLivreur(livreur);
    }

    // DELETE: supprimer un livreur
    @DeleteMapping("/{id}")
    public void deleteLivreur(@PathVariable Long id) {
        livreurService.deleteLivreur(id);
    }
}
