package com.project.portfolio.service;

import com.project.portfolio.model.MisHabilidades;
import com.project.portfolio.repository.MisHabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MisHabilidadesService implements IMisHabilidadesService{
    @Autowired
    private MisHabilidadesRepository habilidadesRepo;

    @Override
    public List<MisHabilidades> getMisHabilidades() {
        List<MisHabilidades>listaHabilidades=habilidadesRepo.findAll();
        return listaHabilidades;
    }

    @Override
    public void saveMisHabilidades(MisHabilidades habil) {
        habilidadesRepo.save(habil);
    }

    @Override
    public void deleteMisHabilidades(Long id) {
        habilidadesRepo.deleteById(id);
    }

    @Override
    public MisHabilidades findMisHabilidades(Long id) {
        MisHabilidades habil = habilidadesRepo.findById(id).orElse(null);
        return habil;
    }
    
}