package com.ClinicaOdontologica3.Odontologia.repository;


import com.ClinicaOdontologica3.Odontologia.model.Domicilios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReproDomicilios extends JpaRepository<Domicilios, Long> {

}
