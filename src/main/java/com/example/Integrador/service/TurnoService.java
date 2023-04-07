package com.example.Integrador.service;

import com.example.Integrador.DTOs.TurnoDTO;
import com.example.Integrador.entitys.Turno;
import com.example.Integrador.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());


    @Override
    @Transactional
    public Set<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;

    }

    private void cargarTurno(TurnoDTO turnoDTO){

        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void agregarTurno(TurnoDTO turnoDTO) {
        cargarTurno(turnoDTO);
    }

    @Override
    @Transactional
    public void modificarTurno(TurnoDTO turnoDTO) {
        cargarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TurnoDTO verTurno(Long id) {
        return mapper.convertValue( turnoRepository.findById(id), TurnoDTO.class);
    }
}
