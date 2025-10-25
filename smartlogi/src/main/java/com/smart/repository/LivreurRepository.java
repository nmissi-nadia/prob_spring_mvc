package com.smart.repository;

import com.smart.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {
    Optional<Livreur> findByTelephone(String telephone);
    boolean existsByNomAndTelephone(String nom, String telephone);
}
