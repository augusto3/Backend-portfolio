package com.project.portfolio.service;

import com.project.portfolio.model.RedesSociales;
import java.util.List;

public interface IRedesSocialesService {
    public List<RedesSociales> getRedes();
    public void saveRedes(RedesSociales redesSociales);
    public void deleteRedes(Long id);
    public RedesSociales findRedes(Long id);
    
}
