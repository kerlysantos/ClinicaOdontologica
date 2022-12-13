package com.ClinicaOdontologica3.Odontologia.service;

import com.ClinicaOdontologica3.Odontologia.exception.ErrorRequestException;
import com.ClinicaOdontologica3.Odontologia.exception.NotFoundException;
import com.ClinicaOdontologica3.Odontologia.model.Turnos;

import java.util.List;

public interface ServiceTurnos {


    Turnos registrarturnos(Turnos turnos) throws ErrorRequestException;

    Turnos actualizarTurnos( Turnos turnos);

    Turnos buscarTurnosPorId( long id);

    List<Turnos> buscarTodosLosTurnos ();

    void eliminarTurnos (long id) throws NotFoundException;

    List<Turnos> listarTurnosPorNombre ( String pacientesNombre);


}
