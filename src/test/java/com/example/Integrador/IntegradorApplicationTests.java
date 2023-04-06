package com.example.Integrador;

import com.example.Integrador.DTOs.PacienteDTO;
import com.example.Integrador.service.IOdontologoService;
import com.example.Integrador.service.IPacienteService;
import com.example.Integrador.service.ITurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IntegradorApplicationTests {

    @Autowired
    private IOdontologoService odontologoService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private ITurnoService turnoService;

    @Test
    public void testcrearPaciente(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Gibbons");
        pacienteDTO.setNombre("Malcolm");
        pacienteDTO.setDomicilio("16 de enero 9382");
        pacienteDTO.setDni(41342820);
        pacienteService.agregarPaciente(pacienteDTO);
        Set<PacienteDTO> pacientes = pacienteService.listarPacientes();

        assertTrue(pacientes != null);

    }

}
