package com.project.portfolio.repository;

import com.project.portfolio.model.Mensajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajesRepository extends JpaRepository <Mensajes,Long>{
    
}
