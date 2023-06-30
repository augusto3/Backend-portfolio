package com.project.portfolio.service;

import com.project.portfolio.model.Proyectos;
import java.util.List;

public interface IProyectosService {
    public List<Proyectos> getProyec();
    public void saveProyec(Proyectos proyectos);
    public void deleteProyec(Long id);
    public Proyectos findProyec(Long id);
    
}
