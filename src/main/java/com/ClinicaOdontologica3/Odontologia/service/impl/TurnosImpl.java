package com.ClinicaOdontologica3.Odontologia.service.impl;


import com.ClinicaOdontologica3.Odontologia.exception.ErrorRequestException;
import com.ClinicaOdontologica3.Odontologia.exception.NotFoundException;
import com.ClinicaOdontologica3.Odontologia.model.Odontologos;
import com.ClinicaOdontologica3.Odontologia.model.Pacientes;
import com.ClinicaOdontologica3.Odontologia.model.Turnos;
import com.ClinicaOdontologica3.Odontologia.repository.ReproOdontologos;
import com.ClinicaOdontologica3.Odontologia.repository.ReproPacientes;
import com.ClinicaOdontologica3.Odontologia.repository.ReproTurnos;
import com.ClinicaOdontologica3.Odontologia.service.ServiceTurnos;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class TurnosImpl  implements ServiceTurnos {
    private static final Logger LOGGER = Logger.getLogger(TurnosImpl.class);

    private final ReproTurnos reproTurnos;

    private final ReproOdontologos reproOdontologos;

    private final ReproPacientes reproPacientes;

    @Autowired
    public TurnosImpl(ReproTurnos reproTurnos,
                      ReproOdontologos reproOdontologos,
                      ReproPacientes reproPacientes) {
        this.reproTurnos = reproTurnos;
        this.reproOdontologos = reproOdontologos;
        this.reproPacientes = reproPacientes;
    }


    @Override
    public Turnos registrarturnos(Turnos turnos) throws ErrorRequestException {
        Optional<Odontologos> odontologos = reproOdontologos.findById(turnos.getId());

        Optional<Pacientes> pacientes = reproPacientes.findById(turnos.getId());


        if (pacientes.isEmpty() || odontologos.isEmpty()) {
            throw new ErrorRequestException("El paciente o el odontologo no existen");
        }

        turnos.setOdontologos(odontologos.get());
        turnos.setPacientes(pacientes.get());


        turnos.setDate((java.sql.Date) new Date());
        LOGGER.info("TURNO GUARDADO EXITOSAMENTE");
        return reproTurnos.save(turnos);
    }

    @Override
    public Turnos actualizarTurnos(Turnos turnos) {
        return reproTurnos.save(turnos);
    }

    @Override
    public Turnos buscarTurnosPorId(long id) {
        return reproTurnos.findById(id).get();
    }


    public List<Turnos> buscarTodosLosTurnos(){
        return reproTurnos.findAll();
    }

    @Override
    public void eliminarTurnos(long id) throws NotFoundException {
        if(Objects.isNull(buscarTurnosPorId(id))) {
            throw new NotFoundException ("No existe turno con id: "+ id);
        }
        reproTurnos.deleteById(id);
    }


    public List<Turnos> listarTurnosPorNombre (String pacientesName) {
        return reproTurnos.listarTurnosPorNombre(pacientesName);
    }

}







