package com.ClinicaOdontologica3.Odontologia.repository;


import com.ClinicaOdontologica3.Odontologia.model.Odontologos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReproOdontologos extends JpaRepository<Odontologos, Long> {
}
