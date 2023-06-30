package com.project.portfolio.service;

import com.project.portfolio.model.Universidad;
import java.util.List;

public interface IUniversidadService {
    public List<Universidad> getUniversidad();
    public void saveUniversidad(Universidad universidad);
    public void deleteUniversidad(Long id);
    public Universidad findUniversidad(Long id);
    
}
