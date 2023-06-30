package com.project.portfolio.controller;

import com.project.portfolio.model.MisHabilidades;
import com.project.portfolio.service.IMisHabilidadesService;
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
@RequestMapping("/habilidades")
public class MisHabilidadesController {
    @Autowired
    private IMisHabilidadesService habil;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<MisHabilidades> getMisHabilidades(){
        return habil.getMisHabilidades();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateMisHabilidades(@RequestBody MisHabilidades habi){
       habil.saveMisHabilidades(habi);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteMisHabilidades (@PathVariable Long id){
        habil.deleteMisHabilidades(id);
        return ("la persona ha sido eliminada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public MisHabilidades editMisHabilidades(@PathVariable Long id,
                               @RequestParam("lenguaje") String lenguaje,
                               @RequestParam("porcentaje") int porcentaje){
        MisHabilidades habi=habil.findMisHabilidades(id);
        habi.setLenguaje(lenguaje);
        habi.setPorcentaje(porcentaje);
        
        habil.saveMisHabilidades(habi);
       
        return habi;
    }
}
