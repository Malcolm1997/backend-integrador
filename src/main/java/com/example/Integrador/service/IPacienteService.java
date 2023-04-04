package com.example.Integrador.service;

import com.example.Integrador.DTOs.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    public Set<PacienteDTO> listarPacientes();
    public void agregarPaciente(PacienteDTO pacienteDTO);
    public void modificarPaciente(PacienteDTO pacienteDTO);
    public void eliminarPaciente(Long id);
}
