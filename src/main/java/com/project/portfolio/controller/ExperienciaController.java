package com.project.portfolio.controller;

import com.project.portfolio.model.Experiencia;
import com.project.portfolio.service.IExperienciaService;
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
@RequestMapping("/experiencia")
public class ExperienciaController {
    @Autowired
    private IExperienciaService expe;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<Experiencia> getExperiencia(){
        return expe.getExperiencia();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateExperiencia(@RequestBody Experiencia exper){
       expe.saveExperiencia(exper);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteExperiencia (@PathVariable Long id){
        expe.deleteExperiencia(id);
        return ("la persona ha sido eliminada correctamente");
    } 
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                               @RequestParam("nombre") String nombre,
                               @RequestParam("puesto") String puesto,
                               @RequestParam("inicio") String inicio,
                               @RequestParam("fin") String fin,
                               @RequestParam("descripcion") String descripcion){
        Experiencia exp=expe.findExperiencia(id);
        exp.setNombreEmpresa(nombre);
        exp.setPuestoTrabajo(puesto);
        exp.setFechaInicio(inicio);
        exp.setFechaFin(fin);
        exp.setDescripcion(descripcion);
        
        expe.saveExperiencia(exp);
       
        return exp;
    }   
}
