package com.example.Integrador;

import com.example.Integrador.entitys.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Integrador.DTOs.OdontologoDTO;
import com.example.Integrador.DTOs.PacienteDTO;
import com.example.Integrador.DTOs.TurnoDTO;
import com.example.Integrador.entitys.Odontologo;
import com.example.Integrador.service.IOdontologoService;
import com.example.Integrador.service.IPacienteService;
import com.example.Integrador.service.ITurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
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

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void inicilizar(){


        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Gibbons");
        pacienteDTO.setNombre("Malcolm");
        pacienteDTO.setDomicilio("16 de enero 9382");
        pacienteDTO.setDni(41342820);
        pacienteService.agregarPaciente(pacienteDTO);
        pacienteService.agregarPaciente(pacienteDTO);
        pacienteService.agregarPaciente(pacienteDTO);
        pacienteService.agregarPaciente(pacienteDTO);
        pacienteService.agregarPaciente(pacienteDTO);
        pacienteService.agregarPaciente(pacienteDTO);

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Chascomus");
        odontologoDTO.setNombre("Fernando");
        odontologoDTO.setMatricula("asdad6546");
        odontologoService.agregarOdontologo(odontologoDTO);
        odontologoService.agregarOdontologo(odontologoDTO);
        odontologoService.agregarOdontologo(odontologoDTO);
        odontologoService.agregarOdontologo(odontologoDTO);
        odontologoService.agregarOdontologo(odontologoDTO);
        odontologoService.agregarOdontologo(odontologoDTO);

        TurnoDTO turnoDTO = new TurnoDTO();
        LocalDateTime fechaHora = LocalDateTime.of(2023,5,30,12,52);
        turnoDTO.setHorarioTurno(fechaHora);
        OdontologoDTO odontologoTurno = odontologoService.verOdontologo(6L);
        PacienteDTO pacienteTurno = pacienteService.verPaciente(6L);
        turnoDTO.setOdontologo(mapper.convertValue(odontologoTurno, Odontologo.class));
        turnoDTO.setPaciente(mapper.convertValue(pacienteTurno, Paciente.class));
        turnoService.agregarTurno(turnoDTO);
        turnoService.agregarTurno(turnoDTO);
        turnoService.agregarTurno(turnoDTO);
        turnoService.agregarTurno(turnoDTO);
        turnoService.agregarTurno(turnoDTO);
        turnoService.agregarTurno(turnoDTO);

    }

    @Test
    public void testcrearPaciente(){
        PacienteDTO paciente1 = pacienteService.verPaciente(3L);
        assertTrue(paciente1.getDni() == 41342820);
        assertTrue(paciente1.getNombre() == "Malcolm");
    }

    @Test
    public void testModificarPaciente(){

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(1L);
        pacienteDTO.setApellido("Gibbons");
        pacienteDTO.setNombre("Federico");
        pacienteDTO.setDomicilio("16 de enero 9382");
        pacienteDTO.setDni(45852158);
        pacienteService.modificarPaciente(pacienteDTO);
        PacienteDTO paciente2 = pacienteService.verPaciente(1L);

        assertTrue(paciente2 != null);
        assertTrue(paciente2.getDni() == 45852158);
        assertTrue(paciente2.getNombre() == "Federico");

    }

    @Test
    public void eliminarPaciente(){
        PacienteDTO pacienteEliminado = pacienteService.verPaciente(1L);
        assertFalse(pacienteEliminado == null);
        pacienteService.eliminarPaciente(1L);
        pacienteEliminado = pacienteService.verPaciente(1L);
        assertTrue(pacienteEliminado == null);
    }

    @Test
    public void testTodosLosPacientes(){
        Set<PacienteDTO> pacientes = pacienteService.listarPacientes();
        assertTrue(pacientes.size() >= 3);
        assertTrue(pacientes != null);
    }



    @Test
    public void testcrearOdontologo(){
        OdontologoDTO odontologo1 = odontologoService.verOdontologo(3L);
        assertTrue(odontologo1.getMatricula() == "asdad6546");
        assertTrue(odontologo1.getNombre() == "Fernando");
    }

    @Test
    public void testModificarOdontologo(){

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setId(2L);
        odontologoDTO.setApellido("Gibbons");
        odontologoDTO.setNombre("Federico");
        odontologoDTO.setMatricula("asdas85478569");
        odontologoService.modificarOdontologo(odontologoDTO);
        OdontologoDTO odontologo2 = odontologoService.verOdontologo(2L);

        assertTrue(odontologo2 != null);
        assertTrue(odontologo2.getMatricula() == "asdas85478569");
        assertTrue(odontologo2.getNombre() == "Federico");

    }

    @Test
    public void eliminarOdontologo(){
        OdontologoDTO odontologoEliminado = odontologoService.verOdontologo(1L);
        assertFalse(odontologoEliminado == null);
        odontologoService.eliminarOdontologo(1L);
        odontologoEliminado = odontologoService.verOdontologo(1L);
        assertTrue(odontologoEliminado == null);
    }

    @Test
    public void testTodosLosOdontologo(){
        Set<OdontologoDTO> odontologos = odontologoService.listarOdontologos();
        assertTrue(odontologos.size() >= 3);
        assertTrue(odontologos != null);
    }



    @Test
    public void testcrearTurno(){
        TurnoDTO turno1 = turnoService.verTurno(3L);
        assertTrue(turno1.getOdontologo().getMatricula() == "asdad6546");
        assertTrue(turno1.getPaciente().getNombre() == "Malcolm");
    }

    @Test
    public void testModificarTurno(){

        PacienteDTO pacienteMod = pacienteService.verPaciente(4L);
        OdontologoDTO odontologoMod = odontologoService.verOdontologo(4L);

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(5L);
        turnoDTO.setPaciente(mapper.convertValue(pacienteMod, Paciente.class));
        turnoDTO.setHorarioTurno(LocalDateTime.of(2022,6,5,9,5));
        turnoDTO.setOdontologo(mapper.convertValue(odontologoMod, Odontologo.class));
        turnoService.modificarTurno(turnoDTO);
        TurnoDTO turno2 = turnoService.verTurno(5L);

        assertTrue(turno2 != null);
        assertTrue(turno2.getHorarioTurno().equals(LocalDateTime.of(2022,6,5,9,5)));
        assertTrue(turno2.getPaciente().getNombre() == pacienteMod.getNombre());

    }

    @Test
    public void eliminarTurno(){
        TurnoDTO turnoEliminado = turnoService.verTurno(1L);
        assertFalse(turnoEliminado == null);
        turnoService.eliminarTurno(1L);
        turnoEliminado = turnoService.verTurno(1L);
        assertTrue(turnoEliminado == null);
    }

    @Test
    public void testTodosLosTurnos(){
        Set<TurnoDTO> turnos = turnoService.listarTurnos();
        assertTrue(turnos.size() >= 3);
        assertTrue(turnos != null);
    }


}
