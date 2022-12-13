package com.ClinicaOdontologica3.Odontologia.security.config;

import com.ClinicaOdontologica3.Odontologia.model.AppUser;
import com.ClinicaOdontologica3.Odontologia.model.AppUserRole;
import com.ClinicaOdontologica3.Odontologia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/*Cuando mi aplicación levante
* generará estos dos usuarios*/

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = passwordEncoder.encode("password");

        String password2 = passwordEncoder.encode("password2");


        userRepository.save(new AppUser("Carlos", "carlos123", "carlos@carlos.com", password, AppUserRole.ADMIN));

        userRepository.save(new AppUser("Beata", "betty", "betty@betty.com", password2, AppUserRole.USER));
    }
}
