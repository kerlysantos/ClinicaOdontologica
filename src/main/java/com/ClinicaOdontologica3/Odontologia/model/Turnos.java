package com.ClinicaOdontologica3.Odontologia.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name="Turno")

public class Turnos {



    @Id
    @SequenceGenerator(name = "secuencia de turnos", sequenceName = "secuencia de turnos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnos")
    @Column (name = "id_Turno")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologos_id")
    @JsonIgnore
    private Odontologos odontologos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pacientes_ID")
    @JsonIgnore
    private Pacientes pacientes;
    @Column(name = "fecha")
    private Date date;


    public Turnos() {
    }

    public Turnos( Odontologos odontologos, Pacientes pacientes, Date date) {

        this.odontologos = odontologos;
        this.pacientes = pacientes;
        this.date = date;
    }

    public Long getId() { return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Odontologos getOdontologos() {
        return odontologos;
    }

    public void setOdontologos(Odontologos odontologos) {
        this.odontologos = odontologos;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Turnos{" +
                "id=" + id +
                ", odontologos=" + odontologos +
                ", pacientes=" + pacientes +
                ", date=" + date +
                '}';
    }
}





