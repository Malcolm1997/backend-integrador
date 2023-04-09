package com.example.Integrador.controller;

import com.example.Integrador.DTOs.TurnoDTO;
import com.example.Integrador.service.ITurnoService;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    private final Logger log = LogManager.getLogger(TurnoController.class);

    @GetMapping
    public Collection<TurnoDTO> obtenerTodos(){
        log.info("Buscando turnos...");
        Set<TurnoDTO> turnos = turnoService.listarTurnos();

        if (turnos.size() == 0){
            log.info("No se han encontrado turnos");
        }
        return turnos;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        log.info("Agregando un turno...");
        turnoService.agregarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        log.info("Actualizando un odontologo...");
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        if (turnoService.verTurno(id) != null){
            log.info("Eliminando un turno...");
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        log.info("El turno no ha sido encontrado");
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public TurnoDTO verTurno(@PathVariable Long id){
        TurnoDTO turnoEncontrado = turnoService.verTurno(id);
        log.info("Buscando el turno ID:" + id + "...");
        if (turnoEncontrado == null){
            log.info("No se a encontrado el turno");
        }
        return turnoEncontrado;
    }


}
