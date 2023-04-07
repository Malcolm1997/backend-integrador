package com.example.Integrador.service;

import com.example.Integrador.DTOs.OdontologoDTO;
import com.example.Integrador.entitys.Odontologo;

import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {

    public Set<OdontologoDTO> listarOdontologos();
    public void agregarOdontologo(OdontologoDTO odontologoDTO);
    public void modificarOdontologo(OdontologoDTO odontologoDTO);
    public void eliminarOdontologo(Long id);
    public OdontologoDTO verOdontologo(Long id);
}
