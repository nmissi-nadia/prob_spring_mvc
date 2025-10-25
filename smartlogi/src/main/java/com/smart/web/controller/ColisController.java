package com.smart.web.controller;

import com.smart.entity.Colis;
import com.smart.service.ColisService;
import com.smart.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/colis")
public class ColisController {

    @Autowired
    private ColisService colisService;

    @PostMapping
    public ResponseEntity<Colis> create(@RequestBody Colis c, @RequestParam(required = false) Long livreurId) {
        return ResponseEntity.ok(colisService.create(c, livreurId));
    }

    @GetMapping
    public ResponseEntity<List<Colis>> all() {
        return ResponseEntity.ok(colisService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colis> get(@PathVariable Long id) {
        return ResponseEntity.of(colisService.findById(id));
    }

    @PutMapping("/{id}/statut")
    public ResponseEntity<Void> changeStatut(@PathVariable Long id, @RequestParam Colis.Statut statut) {
        colisService.changeStatut(id, statut);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        colisService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
