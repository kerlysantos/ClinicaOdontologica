package com.ClinicaOdontologica3.Odontologia.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)

public class PacienteDTO {

    private  long id;
    private  String nombre;
    private  String apellido;
    private  Integer DNi;
    private  Date FechaDeIngreso;

    public PacienteDTO(Long id, String nombre, String apellido, Integer DNi, Date fechaDeIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNi = DNi;
        FechaDeIngreso = fechaDeIngreso;
    }

    public PacienteDTO(){}

    public PacienteDTO(int id, String nombre, String apellido, String DNI, int fechaDeIngreso, String Domicilios) {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDNi(Integer DNi) {
        this.DNi = DNi;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        FechaDeIngreso = fechaDeIngreso;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDNi() {
        return DNi;
    }

    public Date getFechaDeIngreso() {
        return FechaDeIngreso;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNi=" + DNi +
                ", FechaDeIngreso=" + FechaDeIngreso +
                '}';
    }


    public boolean elPacienteSeHaCreado(PacienteDTO pacienteDTO){
        return true;
    }
}
