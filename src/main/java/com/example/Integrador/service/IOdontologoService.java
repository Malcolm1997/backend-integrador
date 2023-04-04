package com.example.Integrador.service;

import com.example.Integrador.DTOs.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    public Set<OdontologoDTO> listarOdontologos();
    public void agregarOdontologo(OdontologoDTO odontologoDTO);
    public void modificarOdontologo(OdontologoDTO odontologoDTO);
    public void eliminarOdontologo(Long id);
}
