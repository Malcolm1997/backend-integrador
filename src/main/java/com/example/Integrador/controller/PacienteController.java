package com.example.Integrador.controller;

import com.example.Integrador.DTOs.OdontologoDTO;
import com.example.Integrador.DTOs.PacienteDTO;
import com.example.Integrador.entitys.Paciente;
import com.example.Integrador.service.IOdontologoService;
import com.example.Integrador.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;



@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @GetMapping
    public Collection<PacienteDTO> obtenerTodos(){
        return pacienteService.listarPacientes();
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.agregarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

