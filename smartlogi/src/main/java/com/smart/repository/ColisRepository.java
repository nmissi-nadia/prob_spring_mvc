package com.smart.repository;

import com.smart.entity.Colis;
import com.smart.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ColisRepository extends JpaRepository<Colis, Long> {
    List<Colis> findByLivreur(Livreur livreur);
    List<Colis> findByStatut(Colis.Statut statut);
}
