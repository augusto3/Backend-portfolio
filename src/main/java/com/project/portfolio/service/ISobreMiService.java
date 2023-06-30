package com.project.portfolio.service;

import com.project.portfolio.model.SobreMi;
import java.util.List;

public interface ISobreMiService{
    public List<SobreMi> getSobreMi();
    public void saveSobreMi(SobreMi sobreMi);
    public void deleteSobreMi(Long id);
    public SobreMi findSobreMi(Long id);
}