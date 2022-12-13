package com.ClinicaOdontologica3.Odontologia.repository;

import com.ClinicaOdontologica3.Odontologia.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
