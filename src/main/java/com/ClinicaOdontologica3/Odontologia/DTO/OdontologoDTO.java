package com.ClinicaOdontologica3.Odontologia.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {

    private Integer matricula;
    private  String apellido;
    private String nombre;

    public OdontologoDTO (){}

    @Override
    public String toString() {
        return "OdontologoDTO{" +
                "matricula=" + matricula +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
