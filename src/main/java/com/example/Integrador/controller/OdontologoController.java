package com.example.Integrador.controller;

import com.example.Integrador.DTOs.OdontologoDTO;
import com.example.Integrador.entitys.Odontologo;
import com.example.Integrador.service.IOdontologoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    private final Logger log = LogManager.getLogger(OdontologoController.class);

    @GetMapping
    public Collection<OdontologoDTO> obtenerTodos(){
        return odontologoService.listarOdontologos();
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        log.info("Agregando un odontologo...");
        odontologoService.agregarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO verOdontologo(@PathVariable Long id){
        return odontologoService.verOdontologo(id);
    }

}
