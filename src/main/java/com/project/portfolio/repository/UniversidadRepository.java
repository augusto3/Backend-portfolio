package com.project.portfolio.repository;

import com.project.portfolio.model.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversidadRepository extends JpaRepository <Universidad, Long>{
   
}
