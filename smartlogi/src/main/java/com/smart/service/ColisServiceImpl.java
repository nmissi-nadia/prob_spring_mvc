package com.smart.service;

import com.smart.entity.Colis;
import com.smart.entity.Livreur;
import com.smart.repository.ColisRepository;
import com.smart.repository.LivreurRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Exemple d'injection par setter (Setter injection)
 */
@Transactional
public class ColisServiceImpl implements ColisService {

    private ColisRepository colisRepository;
    private LivreurService livreurService; // injecté via setter in XML

    public ColisServiceImpl() {}

    // SETTER INJECTION (type 2)
    public void setColisRepository(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    public void setLivreurService(LivreurService livreurService) {
        this.livreurService = livreurService;
    }

    @Override
    public Colis create(Colis c, Long livreurId) {
        if (livreurId != null) {
            Livreur l = livreurService.findById(livreurId).orElseThrow(() -> new IllegalArgumentException("Livreur introuvable"));
            c.setLivreur(l);
        }
        return colisRepository.save(c);
    }

    @Override
    public Colis update(Colis c) { return colisRepository.save(c); }

    @Override
    public void delete(Long id) { colisRepository.deleteById(id); }

    @Override
    public Optional<Colis> findById(Long id) { return colisRepository.findById(id); }

    @Override
    public List<Colis> findAll() { return colisRepository.findAll(); }

    @Override
    public List<Colis> findByLivreur(Livreur livreur) { return colisRepository.findByLivreur(livreur); }

    @Override
    public void changeStatut(Long colisId, Colis.Statut statut) {
        Colis c = colisRepository.findById(colisId).orElseThrow();
        c.setStatut(statut);
        colisRepository.save(c);
    }
}
