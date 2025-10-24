package com.smart.service;

import com.smart.entity.Colis;
import com.smart.repository.ColisRepository;
import com.smart.repository.LivreurRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class ColisService {
    private ColisRepository colisRepository;
    private LivreurRepository livreurRepository;

    public ColisService(ColisRepository colisRepository ,LivreurRepository livreurRepository) {
        this.colisRepository = colisRepository;
        this.livreurRepository = livreurRepository;
    }




    public List<Colis> getAllColis() {
        return colisRepository.findAll();
    }

    // Méthode pour sauvegarder un colis
    public Colis saveColis(Colis colis) {
        return colisRepository.save(colis);
    }

    // Méthode pour supprimer un colis par ID
    public void deleteColis(Long id) {
        colisRepository.deleteById(id);
    }

    public Colis getColisById(Long id) {
        return colisRepository.findById(id).orElse(null);
    }

}
