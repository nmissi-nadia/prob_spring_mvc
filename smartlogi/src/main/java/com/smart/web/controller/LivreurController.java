package com.smart.web.controller;

import com.smart.entity.Livreur;
import com.smart.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livreurs")
public class LivreurController {

    @Autowired
    private LivreurService livreurService;

    @PostMapping
    public ResponseEntity<Livreur> create(@RequestBody Livreur l) {
        return ResponseEntity.ok(livreurService.create(l));
    }

    @GetMapping
    public ResponseEntity<List<Livreur>> all() {
        return ResponseEntity.ok(livreurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livreur> get(@PathVariable Long id) {
        return ResponseEntity.of(livreurService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livreur> update(@PathVariable Long id, @RequestBody Livreur l) {
        l.setId(id);
        return ResponseEntity.ok(livreurService.update(l));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livreurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
