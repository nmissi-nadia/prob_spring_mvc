package com.smart.repository;

import com.smart.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {
    // Tu peux ajouter des méthodes personnalisées ici
}
