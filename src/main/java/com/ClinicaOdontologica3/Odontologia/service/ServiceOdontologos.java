package com.ClinicaOdontologica3.Odontologia.service;

import com.ClinicaOdontologica3.Odontologia.exception.NotFoundException;
import com.ClinicaOdontologica3.Odontologia.model.Odontologos;

import java.util.List;
import java.util.Optional;

public interface ServiceOdontologos {

public List<Odontologos> getOdontologos();

public Odontologos CrearOdontologos (Odontologos odontologos) ;

public Odontologos actualizarOdontologos (long id, Odontologos odontologos);

public Optional<Odontologos> eliminarOdontologo (long id);

    List<Odontologos> buscarTodos();

    Odontologos buscarOdontologoPorId(Long id)  throws NotFoundException;

}
