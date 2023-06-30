package com.project.portfolio.controller;

import com.project.portfolio.model.Cursos;
import com.project.portfolio.service.ICursosService;
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
@RequestMapping("/cursos")
public class CursosController {
    @Autowired
    private ICursosService iCursosService;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<Cursos> getCursos(){
        return iCursosService.getCursos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateCursos(@RequestBody Cursos curso){
    	iCursosService.saveCursos(curso);
       return ("la persona fue creada correctamente");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteCursos (@PathVariable Long id){
    	iCursosService.deleteCursos(id);
        return ("la persona ha sido eliminada correctamente");
    } 

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Cursos editCursos(@PathVariable Long id,
                               @RequestParam("name") String name,
                               @RequestParam("curso") String curso,
                               @RequestParam("certificado") String certificado ){ 
        Cursos cursosModel=iCursosService.findCursos(id);
        cursosModel.setNameCurso(name);
        cursosModel.setUrlCurso(curso);
        cursosModel.setUrlCertificado(certificado);

        iCursosService.saveCursos (cursosModel);
       
        return cursosModel;
    }
}
