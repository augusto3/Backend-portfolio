package com.project.portfolio.service;

import com.project.portfolio.model.Cursos;
import java.util.List;

public interface ICursosService {    
    public List<Cursos> getCursos();
    public void saveCursos(Cursos curso);
    public void deleteCursos(Long id);
    public Cursos findCursos(Long id);
    
}
