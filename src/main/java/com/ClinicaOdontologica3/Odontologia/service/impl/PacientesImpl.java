package com.ClinicaOdontologica3.Odontologia.service.impl;

import com.ClinicaOdontologica3.Odontologia.exception.NotFoundException;
import com.ClinicaOdontologica3.Odontologia.model.Pacientes;
import com.ClinicaOdontologica3.Odontologia.repository.ReproPacientes;
import com.ClinicaOdontologica3.Odontologia.service.ServicePacientes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PacientesImpl implements ServicePacientes {

    private static final Logger LOGGER = Logger.getLogger(PacientesImpl.class);

    @Autowired
    private ReproPacientes reproPacientes;

    public PacientesImpl(ReproPacientes reproPacientes){
        this.reproPacientes = reproPacientes;
    }

    @Override
    public List<Pacientes> getPatientes() {
        return reproPacientes.findAll();}

    @Override
    public Pacientes crearpacientes( @RequestBody Pacientes pacientes)  {
        LOGGER.info("CREADO UN Paciennte ");
        return reproPacientes.save(pacientes);
    }

    @Override
    public Optional<Pacientes> eliminarPacientes(long id) {
        Pacientes eliminarPacientes = reproPacientes.findById(id).get();

        return reproPacientes.findById(id);
    }

    @Override
    public Pacientes actualizarLista(long id, Pacientes pacientes) {
        Pacientes actualizarlista = reproPacientes.findById(id).get();
        actualizarlista.setDNI(pacientes.getDNI());
        actualizarlista.setApellido(pacientes.getApellido());
        actualizarlista.setNombre(pacientes.getNombre());
        actualizarlista.setDomicilios(pacientes.getDomicilios());
        //actualizarlista.setFechaIngreso(pacientes.getFechaIngreso());
        return reproPacientes.save(pacientes);
    }

    @Override
    public List<Pacientes> buscarTodos() {
        return reproPacientes.findAll();
    }

    public Pacientes buscarPacientePorId(Long id) throws NotFoundException {
        if (reproPacientes.findById(id).isEmpty()) {
            throw new NotFoundException("There is not patient with id: " + id);
        }
        return reproPacientes.findById(id).get();
    }

}
