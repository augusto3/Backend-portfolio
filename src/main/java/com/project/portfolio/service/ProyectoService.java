package com.project.portfolio.service;

import com.project.portfolio.model.Proyectos;
import com.project.portfolio.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectosService{
    @Autowired
    private ProyectosRepository proyectoRepo;

    @Override
    public List<Proyectos> getProyec() {
        List<Proyectos>listaProyec=proyectoRepo.findAll();
        return listaProyec;
    }

    @Override
    public void saveProyec(Proyectos proyec) {
        proyectoRepo.save(proyec);
    }

    @Override
    public void deleteProyec(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyectos findProyec(Long id) {
        Proyectos proyec = proyectoRepo.findById(id).orElse(null);
        return proyec;
    }
}
