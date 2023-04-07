package com.example.Integrador.service;

import com.example.Integrador.DTOs.PacienteDTO;
import com.example.Integrador.entitys.Paciente;
import com.example.Integrador.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Set<PacienteDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for (Paciente paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }

        return pacientesDTO;

    }

    private void cargarOdontologo(PacienteDTO pacienteDTO){

        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        paciente.setFechaAlta(new Timestamp(System.currentTimeMillis()));
        pacienteRepository.save(paciente);
    }

    @Override
    public void agregarPaciente(PacienteDTO pacienteDTO) {
        cargarOdontologo(pacienteDTO);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        cargarOdontologo(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO verPaciente(Long id) {
        return mapper.convertValue(pacienteRepository.findById(id), PacienteDTO.class);
    }

}
