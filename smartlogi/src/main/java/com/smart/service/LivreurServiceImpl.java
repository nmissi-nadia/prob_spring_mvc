package com.smart.service;

import com.smart.entity.Livreur;
import com.smart.repository.LivreurRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Exemple d'injection par constructeur (Constructor injection)
 */
@Transactional
public class LivreurServiceImpl implements LivreurService {

    private final LivreurRepository livreurRepository;

    // CONSTRUCTOR INJECTION (type 1)
    public LivreurServiceImpl(LivreurRepository livreurRepository) {
        this.livreurRepository = livreurRepository;
    }

    @Override
    public Livreur create(Livreur l) {
        // évite doublons
        if (l.getTelephone() != null && livreurRepository.findByTelephone(l.getTelephone()).isPresent()) {
            throw new IllegalArgumentException("Livreur avec même téléphone existe déjà");
        }
        return livreurRepository.save(l);
    }

    @Override
    public Livreur update(Livreur l) {
        return livreurRepository.save(l);
    }

    @Override
    public void delete(Long id) {
        livreurRepository.deleteById(id);
    }

    @Override
    public Optional<Livreur> findById(Long id) { return livreurRepository.findById(id); }

    @Override
    public List<Livreur> findAll() { return livreurRepository.findAll(); }
}
