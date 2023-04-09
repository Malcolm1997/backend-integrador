package com.example.Integrador.controller;

import com.example.Integrador.DTOs.OdontologoDTO;
import com.example.Integrador.service.IOdontologoService;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    private final Logger log = Logger.getLogger(OdontologoController.class);

    @GetMapping
    @CrossOrigin(origins = "*")
    public Collection<OdontologoDTO> obtenerTodos(){
        log.info("Buscando a todos los odontologos");
        Set<OdontologoDTO> odontologos = odontologoService.listarOdontologos();

        if (odontologos.size() == 0){
            log.error("No se han encontrado odontologos");
        }
        return odontologos;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        log.info("Agregando un odontologo...");
        odontologoService.agregarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        log.info("Actulizando un odontologo...");
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        if (odontologoService.verOdontologo(id) != null){
            log.info("Eliminando un odontologo...");
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        log.error("El odontologo no se a econtrado");
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public OdontologoDTO verOdontologo(@PathVariable Long id){
        OdontologoDTO odontologoEncontrado = odontologoService.verOdontologo(id);
        log.info("Buscando el odontologo ID:"+ id + " ...");
        if (odontologoEncontrado == null){
            log.error("No se a encontrado al Odontologo...");
        }
        return odontologoEncontrado;
    }

}
