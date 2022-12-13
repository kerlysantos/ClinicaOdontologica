package com.ClinicaOdontologica3.Odontologia.repository;


import com.ClinicaOdontologica3.Odontologia.model.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReproPacientes extends JpaRepository<Pacientes, Long> {
}
