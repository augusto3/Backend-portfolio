package com.project.portfolio.repository;

import com.project.portfolio.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository <Cursos,Long>{
    
}
