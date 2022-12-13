package com.ClinicaOdontologica3.Odontologia.service.impl;

import com.ClinicaOdontologica3.Odontologia.model.Domicilios;
import com.ClinicaOdontologica3.Odontologia.repository.ReproDomicilios;
import com.ClinicaOdontologica3.Odontologia.service.ServiceDomicilios;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomiciliosImpl implements ServiceDomicilios {

    private final ReproDomicilios reproDomicilios;
    private Iterable<Long> id;

    public DomiciliosImpl(ReproDomicilios reproDomicilios) {
        this.reproDomicilios = reproDomicilios;
    }

    public Domicilios guardar(Domicilios domicilios) {
        reproDomicilios.save(domicilios);
        return domicilios;
    }



    @Override
    public Domicilios buscar() {
        return (Domicilios) reproDomicilios.findAllById(id);
    }


    @Override
    public List<Domicilios> buscarTodos() {
        return reproDomicilios.findAll();
    }

    @Override
    public void eliminar(Long id) {
        reproDomicilios.deleteById(id);
    }
}
