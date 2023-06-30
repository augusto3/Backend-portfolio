package com.project.portfolio.service;

import com.project.portfolio.model.Experiencia;
import com.project.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private ExperienciaRepository experienciaRepo;

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia>listaExpe=experienciaRepo.findAll();
        return listaExpe;
    }

    @Override
    public void saveExperiencia(Experiencia expe) {
        experienciaRepo.save(expe);
    }

    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepo.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia expe = experienciaRepo.findById(id).orElse(null);
        return expe;
    }
}