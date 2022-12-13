package com.ClinicaOdontologica3.Odontologia.service;

import com.ClinicaOdontologica3.Odontologia.model.Domicilios;

import java.util.List;

public interface ServiceDomicilios {

    Domicilios buscar();

    public List<Domicilios> buscarTodos();

    void eliminar(Long id);
}


