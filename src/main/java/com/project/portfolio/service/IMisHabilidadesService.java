package com.project.portfolio.service;

import com.project.portfolio.model.MisHabilidades;
import java.util.List;

public interface IMisHabilidadesService {
    public List<MisHabilidades> getMisHabilidades();
    public void saveMisHabilidades (MisHabilidades misHabilidades);
    public void deleteMisHabilidades(Long id);
    public MisHabilidades findMisHabilidades(Long id);

}
