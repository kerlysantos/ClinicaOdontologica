package com.ClinicaOdontologica3.Odontologia.service;


import com.ClinicaOdontologica3.Odontologia.exception.NotFoundException;
import com.ClinicaOdontologica3.Odontologia.model.Pacientes;

import java.util.List;
import java.util.Optional;


public interface ServicePacientes{

    public List<Pacientes> getPatientes();

    public Pacientes crearpacientes(Pacientes pacientes) ;

    public Optional<Pacientes> eliminarPacientes (long id);

    public Pacientes actualizarLista (long id , Pacientes pacientes);

    List<Pacientes> buscarTodos();

    Pacientes buscarPacientePorId(Long id)  throws NotFoundException;

}
