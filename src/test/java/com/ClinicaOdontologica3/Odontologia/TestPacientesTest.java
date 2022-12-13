package com.ClinicaOdontologica3.Odontologia;

import com.ClinicaOdontologica3.Odontologia.DTO.PacienteDTO;
import com.ClinicaOdontologica3.Odontologia.model.Pacientes;
import com.ClinicaOdontologica3.Odontologia.service.ServicePacientes;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class TestPacientesTest {

    private static Pacientes pacientes;



    @Test
    public void EsteSeraElPrimerTestDePruebasConPacientes(){
        // THEN //
        PacienteDTO pacientesDTO = new PacienteDTO(1,"kerly", "santos", "95882688", 25/01/2022,"Buenos aires ");
        // WHEN //
        boolean pacienteCreado = pacientesDTO.elPacienteSeHaCreado(pacientesDTO);
        // GIVEN //
        assertTrue(pacienteCreado);

    }

    @org.junit.Test
    public void traerTodos() {
        Class<ServicePacientes> pacientes = ServicePacientes.class;
        Assert.assertTrue(!pacientes.isArray());
        Assert.assertTrue(pacientes.isArray() );
        System.out.println(pacientes);
    }

}