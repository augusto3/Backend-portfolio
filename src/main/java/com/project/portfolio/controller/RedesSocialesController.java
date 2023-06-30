package com.project.portfolio.controller;

import com.project.portfolio.model.RedesSociales;
import com.project.portfolio.service.IRedesSocialesService;
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
@RequestMapping("/redes")

public class RedesSocialesController {
    @Autowired
    private IRedesSocialesService redes;
    
    @GetMapping("/datos")
    @ResponseBody
    public List<RedesSociales> getRedes(){
        return redes.getRedes();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String CreateRedes(@RequestBody RedesSociales rede){
       redes.saveRedes(rede);
       return ("la persona fue creada correctamente");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteRedes (@PathVariable Long id){
        redes.deleteRedes(id);
        return ("la persona ha sido eliminada correctamente");
    } 
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public RedesSociales editRedes(@PathVariable Long id,
                               @RequestParam("instagram") String nuevoInstagram,
                               @RequestParam("linkedin") String nuevoLinkedin,
                               @RequestParam("facebook") String nuevoFacebook){

        RedesSociales rede=redes.findRedes(id);
        rede.setInstagram(nuevoInstagram);
        rede.setLinkedin(nuevoLinkedin);
        rede.setFacebook(nuevoFacebook);
        
        redes.saveRedes(rede);
       
        return rede;
    }
}
