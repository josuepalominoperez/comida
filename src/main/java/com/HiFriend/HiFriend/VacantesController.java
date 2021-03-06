package com.HiFriend.HiFriend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante , Model model){
        System.out.println("idVacante: "+idVacante);
        model.addAttribute("idVacante", idVacante);
        return "detalles";
    }

    @GetMapping("/delete")
    public String borrando(@RequestParam("id") int idVacante, Model model){
        System.out.println("Borrando vacante con id: "+idVacante);
        model.addAttribute("id", idVacante);
        return "delete";
    }

    
}