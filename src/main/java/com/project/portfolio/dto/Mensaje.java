package com.project.portfolio.dto;

import org.springframework.http.HttpStatus;

public class Mensaje {
    private String mensaje;
    private HttpStatus status=HttpStatus.OK;
    
    public Mensaje(HttpStatus status, String mensaje) {
        this.mensaje = mensaje;
        this.status =status;
    }
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
