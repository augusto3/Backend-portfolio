package com.project.portfolio.controller;

import com.project.portfolio.model.Educacion;
import com.project.portfolio.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")

public class EducacionController {
    @Autowired
    private IEducacionService edu;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<Educacion> getEducacion(){
        return edu.getEducacion();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateEducacion(@RequestBody Educacion educ){
       edu.saveEducacion(educ);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteEducacion (@PathVariable Long id){
        edu.deleteEducacion(id);
        return ("la persona ha sido eliminada correctamente");
    } 




}
