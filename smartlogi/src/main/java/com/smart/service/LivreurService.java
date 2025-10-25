package com.smart.service;

import com.smart.entity.Livreur;
import java.util.List;
import java.util.Optional;

public interface LivreurService {
    Livreur create(Livreur l);
    Livreur update(Livreur l);
    void delete(Long id);
    Optional<Livreur> findById(Long id);
    List<Livreur> findAll();
}
