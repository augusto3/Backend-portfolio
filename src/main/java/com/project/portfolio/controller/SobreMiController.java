package com.project.portfolio.controller;

import com.project.portfolio.model.SobreMi;
import com.project.portfolio.service.ISobreMiService;
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
@RequestMapping("/sobremi")
public class SobreMiController {
    @Autowired
    private ISobreMiService interSobreMi;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<SobreMi> getSobreMi(){
        return interSobreMi.getSobreMi();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateSobreMi(@RequestBody SobreMi sobre){
       interSobreMi.saveSobreMi(sobre);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteSobreMi (@PathVariable Long id){
        interSobreMi.deleteSobreMi(id);
        return ("la persona ha sido eliminada correctamente");
    } 
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public SobreMi editSobreMi(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("nacimiento") String nuevoFechaDeNacimiento,
                               @RequestParam("descripcion") String nuevoDescripcion,
                               @RequestParam("foto") String nuevoUrlFoto){
        SobreMi sobre=interSobreMi.findSobreMi(id);
        sobre.setNombre(nuevoNombre);
        sobre.setFechaDeNacimiento(nuevoFechaDeNacimiento);
        sobre.setDescripcion(nuevoDescripcion);
        sobre.setUrlFoto(nuevoUrlFoto);
        
        interSobreMi.saveSobreMi(sobre);
       
        return sobre;
    }
}