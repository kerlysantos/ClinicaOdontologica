package com.ClinicaOdontologica3.Odontologia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
public class Odontologos {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  long id;
     private String apellido;
     private String nombre;

     @Column (name = "matricula")
     private String matricula;

     @OneToMany(mappedBy = "odontologos", fetch = FetchType.LAZY)
     @JsonIgnore
     private Set<Turnos> turnos;

     public  Odontologos(){}

    public Odontologos( String apellido, String nombre, String matricula) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }
    public Odontologos(Long id,String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Long getId() { return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologos{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
