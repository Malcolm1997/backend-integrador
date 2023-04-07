package com.example.Integrador.service;

import com.example.Integrador.DTOs.OdontologoDTO;
import com.example.Integrador.entitys.Odontologo;
import com.example.Integrador.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for (Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }

        return odontologosDTO;

    }

    private void cargarOdontologo(OdontologoDTO odontologoDTO){


        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void agregarOdontologo(OdontologoDTO odontologoDTO) {
        cargarOdontologo(odontologoDTO);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        cargarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO verOdontologo(Long id) {
        return  mapper.convertValue( odontologoRepository.findById(id) , OdontologoDTO.class);
    }
}
