package com.project.portfolio.service;

import com.project.portfolio.model.Educacion;
import com.project.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    @Autowired
    private EducacionRepository educaRepo;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion>listaEduca=educaRepo.findAll();
        return listaEduca;
    }

    @Override
    public void saveEducacion(Educacion educa) {
        educaRepo.save(educa);
    }

    @Override
    public void deleteEducacion(Long id) {
        educaRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educa = educaRepo.findById(id).orElse(null);
        return educa;
    }
}
