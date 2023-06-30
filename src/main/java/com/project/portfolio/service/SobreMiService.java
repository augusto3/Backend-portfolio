package com.project.portfolio.service;

import com.project.portfolio.model.SobreMi;
import com.project.portfolio.repository.SobreMiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SobreMiService implements ISobreMiService{
    @Autowired
    private SobreMiRepository sobreMiRepository;

    @Override
    public List<SobreMi> getSobreMi() {
        List<SobreMi>listaSobreMi=sobreMiRepository.findAll();
        return listaSobreMi;
    }

    @Override
    public void saveSobreMi(SobreMi sobreMi) {
        sobreMiRepository.save(sobreMi);
    }

    @Override
    public void deleteSobreMi(Long id) {
        sobreMiRepository.deleteById(id);
    }

    @Override
    public SobreMi findSobreMi(Long id) {
        SobreMi sobre = sobreMiRepository.findById(id).orElse(null);
        return sobre;
    }
    
}
