package com.ClinicaOdontologica3.Odontologia.contoller;

import com.ClinicaOdontologica3.Odontologia.model.Pacientes;
import com.ClinicaOdontologica3.Odontologia.service.ServicePacientes;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Pacientes")
public class PacienteController{

    private static final Logger LOGGER = Logger.getLogger(PacienteController.class);

    private final ServicePacientes servicePacientes;


    public PacienteController(ServicePacientes servicePacientes) {
        this.servicePacientes = servicePacientes;
    }

    @GetMapping("/Paciente")
    public List<Pacientes> getPacientes() {
        return servicePacientes.getPatientes();
    }

    @PostMapping("/nuevoPaciente")

    public ResponseEntity<Pacientes> crearpacientes(@RequestBody Pacientes pacientes)  {
        return ResponseEntity.ok(servicePacientes.crearpacientes(pacientes));
    }


    @PutMapping("/ActualizarLista/{id}")
    public Pacientes actualizarLista(@PathVariable long id, @RequestBody Pacientes pacientes) {
        return servicePacientes.actualizarLista(id, pacientes);}


        @DeleteMapping("/EliminarPacientes/{id}")
        public Optional<Pacientes> eliminarPacientes (@PathVariable long id) {
            return servicePacientes.eliminarPacientes(id);
        }

    @GetMapping
    public ResponseEntity<List<Pacientes>> buscarTodos() {
        LOGGER.info("buscando  todos los  pacientes");
        return  ResponseEntity.ok(servicePacientes.buscarTodos());
    }



}



