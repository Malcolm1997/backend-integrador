package com.example.Integrador.service;

import com.example.Integrador.DTOs.TurnoDTO;
import com.example.Integrador.entitys.Turno;

import java.util.Optional;
import java.util.Set;

public interface ITurnoService {

    public Set<TurnoDTO> listarTurnos();
    public void agregarTurno(TurnoDTO turnoDTO);
    public void modificarTurno(TurnoDTO turnoDTO);
    public void eliminarTurno(Long id);
    public TurnoDTO verTurno(Long id);
}
