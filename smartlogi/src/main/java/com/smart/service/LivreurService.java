package com.smart.service;

import com.smart.entity.Livreur;
import com.smart.repository.LivreurRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class LivreurService {
    private final LivreurRepository livreurRepository;

    public LivreurService(LivreurRepository livreurRepository) {
        this.livreurRepository = livreurRepository;
    }



    public List<Livreur> getAllLivreurs() {
        return livreurRepository.findAll();
    }

    // Méthode pour sauvegarder un livreur
    public Livreur saveLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    // Méthode pour supprimer un livreur
    public void deleteLivreur(Long id) {
        livreurRepository.deleteById(id);
    }
}
