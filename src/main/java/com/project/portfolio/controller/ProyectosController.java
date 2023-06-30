package com.project.portfolio.controller;

import com.project.portfolio.model.Proyectos;
import com.project.portfolio.service.IProyectosService;
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
@RequestMapping("/proyectos")
public class ProyectosController {
    @Autowired
    private IProyectosService proyec;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<Proyectos> getProyecto(){
        return proyec.getProyec();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateProyecto(@RequestBody Proyectos proye){
       proyec.saveProyec(proye);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteProyecto (@PathVariable Long id){
        proyec.deleteProyec(id);
        return ("la persona ha sido eliminada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Proyectos editProyecto(@PathVariable Long id,
                               @RequestParam("nombre") String nameProyecto,
                               @RequestParam("url") String urlProyecto ,
                               @RequestParam("descripcion") String descripcion){
        Proyectos proye=proyec.findProyec(id);
        proye.setNameProyectos(nameProyecto);
        proye.setUrlProyectos(urlProyecto);
        proye.setDescripcion(descripcion);
        
        proyec.saveProyec(proye);
       
        return proye;
    }
}
