package com.smart.controller;

import com.smart.entity.Colis;
import com.smart.service.ColisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colis")
public class ColisController {

    private ColisService colisService;

    public ColisController(ColisService colisService){
        this.colisService = colisService;
    }
    //  Récupérer tous les colis
    @GetMapping
    public List<Colis> getAllColis() {
        return colisService.getAllColis();
    }

    //  Récupérer un colis par son ID
    @GetMapping("/{id}")
    public Colis getColisById(@PathVariable Long id) {
        return colisService.getColisById(id);
    }

    //  Ajouter un colis
    @PostMapping
    public Colis addColis(@RequestBody Colis colis) {
        return colisService.saveColis(colis);
    }

    //  Mettre à jour un colis


    //  Supprimer un colis
    @DeleteMapping("/{id}")
    public void deleteColis(@PathVariable Long id) {
        colisService.deleteColis(id);
    }
}
