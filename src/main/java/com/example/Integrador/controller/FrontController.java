package com.example.Integrador.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class FrontController {


    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/gestorOdontologos")
    public String odontologs(){

        return "odontologosGestion";
    }

    @GetMapping("/gestorPacientes")
    public String pacientes(){

        return "pacientesGestion";
    }

    @GetMapping("/gestorTurnos")
    public String turnos(){

        return "turnosGestion";
    }


}
