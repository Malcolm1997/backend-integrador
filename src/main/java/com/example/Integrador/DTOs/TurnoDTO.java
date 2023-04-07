package com.example.Integrador.DTOs;

import com.example.Integrador.entitys.Odontologo;
import com.example.Integrador.entitys.Paciente;

import java.time.LocalDateTime;

public class TurnoDTO {

    private Long id;
    private LocalDateTime horarioTurno;
    private Paciente paciente;
    private Odontologo odontologo;

    public TurnoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorarioTurno() {
        return horarioTurno;
    }

    public void setHorarioTurno(LocalDateTime horarioTurno) {
        this.horarioTurno = horarioTurno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
