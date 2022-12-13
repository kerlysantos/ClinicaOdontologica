package com.ClinicaOdontologica3.Odontologia.model;



import javax.persistence.*;
@Entity
@Table (name = "Domicilios")

public class Domicilios {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private long id;
    @Column (name = "calle")
    private  String calle;
    @Column (name = "provincia")
    private  String provincia;
    @Column (name = "localidad")
    private  String localidad;

    @OneToOne (mappedBy = "domicilios")
    private Pacientes pacientes;

    public Domicilios(){}

    public Domicilios(long id, String calle, String provincia, String localidad, Pacientes pacientes) {
        this.id = id;
        this.calle = calle;
        this.provincia = provincia;
        this.localidad = localidad;
        this.pacientes = pacientes;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Domicilios{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", provincia='" + provincia + '\'' +
                ", localidad='" + localidad + '\'' +
                ", pacientes=" + pacientes +
                '}';
    }
}
