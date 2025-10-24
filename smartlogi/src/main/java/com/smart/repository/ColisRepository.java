package com.smart.repository;

import com.smart.entity.Colis;
import com.smart.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ColisRepository extends JpaRepository<Colis, Long>{
    // Méthodes personnalisées si besoin
}
