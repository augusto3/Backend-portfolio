package com.project.portfolio.service;

import com.project.portfolio.model.Mensajes;
import com.project.portfolio.repository.MensajesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajesService implements IMensajesService{
    @Autowired
    private MensajesRepository mensajesRepo;

    @Override
    public List<Mensajes> getMensajes() {
        List<Mensajes>listaMensajes=mensajesRepo.findAll();
        return listaMensajes;
    }

    @Override
    public void saveMensajes(Mensajes mensaje) {
        mensajesRepo.save(mensaje);
    }

    @Override
    public void deleteMensajes(Long id) {
        mensajesRepo.deleteById(id);
    }

    @Override
    public Mensajes findMensajes(Long id) {
        Mensajes mensaje = mensajesRepo.findById(id).orElse(null);
        return mensaje;
    }
    
}