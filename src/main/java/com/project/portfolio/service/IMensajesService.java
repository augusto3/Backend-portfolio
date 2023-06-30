package com.project.portfolio.service;

import com.project.portfolio.model.Mensajes;
import java.util.List;

public interface IMensajesService {
    public List<Mensajes> getMensajes();
    public void saveMensajes(Mensajes mensajes);
    public void deleteMensajes(Long id);
    public Mensajes findMensajes(Long id);
}
