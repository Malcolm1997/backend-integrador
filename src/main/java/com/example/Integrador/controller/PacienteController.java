package com.example.Integrador.controller;

import com.example.Integrador.DTOs.PacienteDTO;
import com.example.Integrador.service.IPacienteService;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    private final Logger log = Logger.getLogger(PacienteController.class);

    @GetMapping
    public Collection<PacienteDTO> obtenerTodos(){
        log.info("Buscando pacientes...");
        Set<PacienteDTO> pacientes = pacienteService.listarPacientes();

        if (pacientes.size() == 0){
            log.error("No se han encontrado pacientes");
        }
        return pacientes;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        log.info("Agregando pacientes...");
        pacienteService.agregarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        log.info("Actualizando pacientes...");
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        if (pacienteService.verPaciente(id) != null) {
            log.info("Eliminando paciente");
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        log.error("El paciente no se a encontrado");
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public PacienteDTO verPaciente(@PathVariable Long id){
        PacienteDTO pacienteEncontrado = pacienteService.verPaciente(id);
        log.info("Buscando el paciente ID:"+ id + "...");
        if (pacienteEncontrado == null){
            log.error("No se a encontrado al Paciente...");
        }
        return pacienteEncontrado;
    }
}

