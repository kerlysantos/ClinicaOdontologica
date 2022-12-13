package com.ClinicaOdontologica3.Odontologia.repository;


import com.ClinicaOdontologica3.Odontologia.model.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReproTurnos extends JpaRepository<Turnos, Long> {

    @Query("SELECT a FROM Turnos a WHERE a.pacientes.nombre = ?1")
    List<Turnos> listarTurnosPorNombre(String pacientesNombre);

}
