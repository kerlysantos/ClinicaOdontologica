package com.ClinicaOdontologica3.Odontologia.service.impl;

import com.ClinicaOdontologica3.Odontologia.exception.NotFoundException;
import com.ClinicaOdontologica3.Odontologia.model.Odontologos;
import com.ClinicaOdontologica3.Odontologia.repository.ReproOdontologos;
import com.ClinicaOdontologica3.Odontologia.service.ServiceOdontologos;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OdontologoImpl implements ServiceOdontologos {

    private static final Logger LOGGER = Logger.getLogger(OdontologoImpl.class);
    @Autowired
    private ReproOdontologos reproOdontologos;


    public OdontologoImpl(ReproOdontologos reproOdontologos) {
        this.reproOdontologos = reproOdontologos;
    }

    @Override
    public List<Odontologos> getOdontologos() {
        return reproOdontologos.findAll();
    }

    @Override
    public Odontologos CrearOdontologos(Odontologos odontologos) {
        LOGGER.info("GUARDANDO UN ODONTOLOGO ");
        return reproOdontologos.save(odontologos);
    }
    @Override
    public Odontologos actualizarOdontologos(long id, Odontologos odontologos) {
         Odontologos actualizarOdontologos = reproOdontologos.findById(id).get();
         actualizarOdontologos.setApellido(odontologos.getApellido());
         actualizarOdontologos.setNombre(odontologos.getNombre());
         actualizarOdontologos.setMatricula(odontologos.getMatricula());

         return reproOdontologos.save(odontologos);
    }

    @Override
    public Optional<Odontologos> eliminarOdontologo(long id) {
        Odontologos eliminarOdontologo = reproOdontologos.findById(id).get();
        return reproOdontologos.findById(id);

    }

    public List<Odontologos> buscarTodos() {
        return reproOdontologos.findAll();
    }

    public Odontologos buscarOdontologoPorId(Long id) throws NotFoundException {
        if (reproOdontologos.findById(id).isEmpty()) {
            throw new NotFoundException("There is not dentist with id: " + id);
        }
        return reproOdontologos.findById(id).get();
    }

}