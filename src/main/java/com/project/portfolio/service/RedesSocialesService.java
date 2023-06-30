package com.project.portfolio.service;

import com.project.portfolio.model.RedesSociales;
import com.project.portfolio.repository.RedesSocialesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedesSocialesService implements IRedesSocialesService {
    @Autowired
    private RedesSocialesRepository redes;

    @Override
    public List<RedesSociales> getRedes() {
        List<RedesSociales>listaRedes=redes.findAll();
        return listaRedes;
    }

    @Override
    public void saveRedes(RedesSociales redesSociales) {
        redes.save(redesSociales);
    }

    @Override
    public void deleteRedes(Long id) {
        redes.deleteById(id);
    }

    @Override
    public RedesSociales findRedes(Long id) {
        RedesSociales redesSo = redes.findById(id).orElse(null);
        return redesSo;
    }
}