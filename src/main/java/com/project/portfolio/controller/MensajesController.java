package com.project.portfolio.controller;

import com.project.portfolio.model.Mensajes;
import com.project.portfolio.service.IMensajesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensajes")

public class MensajesController {
    @Autowired
    private IMensajesService msj;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<Mensajes> getMensajes(){
        return msj.getMensajes();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateMensajes(@RequestBody Mensajes mensaje){
       msj.saveMensajes(mensaje);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteMensajes (@PathVariable Long id){
        msj.deleteMensajes(id);
        return ("la persona ha sido eliminada correctamente");
    } 
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Mensajes editMensajes(@PathVariable Long id,
                               @RequestParam("nombre") String nombre,
                               @RequestParam("apellido") String apellido,
                               @RequestParam("celular") String celular,
                               @RequestParam("email") String email,
                               @RequestParam("mensaje") String mensaje,
                               @RequestParam("fecha") String fecha){ 
        Mensajes mensaj=msj.findMensajes(id);
        mensaj.setNombre(nombre);
        mensaj.setApellido(apellido);
        mensaj.setCelular(celular);
        mensaj.setEmail(email);
        mensaj.setMensaje(mensaje);
        mensaj.setFecha(fecha);
        
        msj.saveMensajes(mensaj);
       
        return mensaj;
    }
}