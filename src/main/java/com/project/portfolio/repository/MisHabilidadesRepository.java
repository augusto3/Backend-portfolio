package com.project.portfolio.repository;

import com.project.portfolio.model.MisHabilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MisHabilidadesRepository extends JpaRepository <MisHabilidades, Long> {
    
}
