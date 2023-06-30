package com.project.portfolio.controller;

import com.project.portfolio.model.Universidad;
import com.project.portfolio.service.IUniversidadService;
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
@RequestMapping("/universidad")
public class UniversidadController {
    @Autowired
    private IUniversidadService uni;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<Universidad> getUniversidad(){
        return uni.getUniversidad();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateUniversidad(@RequestBody Universidad univ){
       uni.saveUniversidad(univ);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteUniversidad (@PathVariable Long id){
        uni.deleteUniversidad(id);
        return ("la persona ha sido eliminada correctamente");
    } 
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Universidad editUniversidad(@PathVariable Long id,
                               @RequestParam("universidad") String universidad,
                               @RequestParam("curso") String curso,
                               @RequestParam("inicio") String incio,
                               @RequestParam("fin") String fin,
                               @RequestParam("historial") String historial){ 
        Universidad univ=uni.findUniversidad(id);
        univ.setNameUniversidad(universidad);
        univ.setNameCursos(curso);
        univ.setFechaInicio(incio);
        univ.setFechaFin(fin);
        univ.setHistorialAcademico(historial);

        uni.saveUniversidad (univ);
       
        return univ;
    }
}
