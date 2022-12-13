package com.ClinicaOdontologica3.Odontologia.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table ( name = "Pacientes")

public class Pacientes {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 45)
    private  String nombre;
    @Column(nullable = false, length = 45)
    private  String apellido;
    @Column(nullable = false, length = 45)
    private  String dni;

    @Column(nullable = false, length = 45)
    private Date fechaIngreso;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "domicilio_ID", referencedColumnName = "id")
    private  Domicilios domicilios;

    @OneToMany (mappedBy = "pacientes", fetch = FetchType.LAZY)
    private List<Turnos> turnos;

    public Pacientes() {
    }

    public Pacientes(long id, String nombre, String apellido, String dni, Domicilios domicilios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilios = domicilios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String DNI) {
        this.dni = DNI;
    }

    public Date getFechaIngreso() {
       return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilios getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(Domicilios domicilios) {
        this.domicilios = domicilios;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilios=" + domicilios +
                ", turnos=" + turnos +
                '}';
    }
}
