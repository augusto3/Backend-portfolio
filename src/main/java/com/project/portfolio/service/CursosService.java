package com.project.portfolio.service;

import com.project.portfolio.model.Cursos;
import com.project.portfolio.repository.CursosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosService implements ICursosService{
    @Autowired
    private CursosRepository cursoRepo;

    @Override
    public List<Cursos> getCursos() {
        List<Cursos>listaCursos=cursoRepo.findAll();
        return listaCursos;
    }

    @Override
    public void saveCursos(Cursos curso) {
        cursoRepo.save(curso);
    }

    @Override
    public void deleteCursos(Long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public Cursos findCursos(Long id) {
        Cursos curso = cursoRepo.findById(id).orElse(null);
        return curso;
    }
}