package com.ClinicaOdontologica3.Odontologia.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

    private Date date;


    public TurnoDTO(){}

    public TurnoDTO( Date date) {

        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TurnoDTO{" +
                "date=" + date +
                '}';
    }
}
