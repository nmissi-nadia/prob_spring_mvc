package com.smart.service;

import com.smart.entity.Colis;
import com.smart.entity.Livreur;
import java.util.List;
import java.util.Optional;

public interface ColisService {
    Colis create(Colis c, Long livreurId);
    Colis update(Colis c);
    void delete(Long id);
    Optional<Colis> findById(Long id);
    List<Colis> findAll();
    List<Colis> findByLivreur(Livreur livreur);
    void changeStatut(Long colisId, Colis.Statut statut);
}
