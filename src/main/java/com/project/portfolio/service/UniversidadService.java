package com.project.portfolio.service;

import com.project.portfolio.model.Universidad;
import com.project.portfolio.repository.UniversidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversidadService implements IUniversidadService{
    @Autowired
    private UniversidadRepository universidadRepository;

    @Override
    public List<Universidad> getUniversidad() {
        List<Universidad>listaUniversidad=universidadRepository.findAll();
        return listaUniversidad;
    }

    @Override
    public void saveUniversidad(Universidad universidad) {
        universidadRepository.save(universidad);
    }

    @Override
    public void deleteUniversidad(Long id) {
        universidadRepository.deleteById(id);
    }

    @Override
    public Universidad findUniversidad(Long id) {
        Universidad univ = universidadRepository.findById(id).orElse(null);
        return univ;
    }    
}