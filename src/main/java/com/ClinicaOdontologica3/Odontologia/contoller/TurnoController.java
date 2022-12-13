package com.ClinicaOdontologica3.Odontologia.contoller;


import com.ClinicaOdontologica3.Odontologia.exception.ErrorRequestException;
import com.ClinicaOdontologica3.Odontologia.exception.NotFoundException;
import com.ClinicaOdontologica3.Odontologia.model.Turnos;
import com.ClinicaOdontologica3.Odontologia.service.impl.OdontologoImpl;
import com.ClinicaOdontologica3.Odontologia.service.impl.PacientesImpl;
import com.ClinicaOdontologica3.Odontologia.service.impl.TurnosImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnosImpl ServiceTurnos;
    private OdontologoImpl serviceOdontologos;

    private PacientesImpl servicePacientes;

    @Autowired
    public TurnoController(TurnosImpl serviceTurnos, OdontologoImpl serviceOdontologos, PacientesImpl servicePacientes) {
        this.ServiceTurnos = serviceTurnos;
        this.serviceOdontologos = serviceOdontologos;
        this.servicePacientes = servicePacientes;
    }

    @PostMapping("/nuevoTurno")
    public ResponseEntity<Turnos> registrarTurnos(@RequestBody Turnos turnos)
            throws ErrorRequestException, NotFoundException {
        ResponseEntity<Turnos> response;

        if (servicePacientes.buscarPacientePorId(turnos.getPacientes().getId()) != null &&
                serviceOdontologos.buscarOdontologoPorId(turnos.getOdontologos().getId()) != null) {
            response = ResponseEntity.ok(ServiceTurnos.registrarturnos(turnos));
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @PutMapping("/actualizarturnos")
    public ResponseEntity<Turnos> actualizarTurnos(@RequestBody Turnos turnos) {
        return ResponseEntity.ok(ServiceTurnos.actualizarTurnos(turnos));
    }

    @GetMapping("/Turnos")
    public ResponseEntity<List<Turnos>> BuscartodosLosTurnos() {
        return ResponseEntity.ok(ServiceTurnos.buscarTodosLosTurnos());
    }



    @GetMapping("/turnos/{id}")
    public ResponseEntity<Turnos> buscarTurnosPorId(@PathVariable Long id) {
        Turnos turnos = ServiceTurnos.buscarTurnosPorId(id);
        return ResponseEntity.ok(turnos);
    }



    @DeleteMapping("/turnos/{id}")
    public ResponseEntity<String> eliminarTurnos(@PathVariable Integer id) throws NotFoundException{
        ResponseEntity<String> response = null;

        if (ServiceTurnos.buscarTurnosPorId(id) != null) {
            ServiceTurnos.eliminarTurnos(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("turno eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;

    }

    @GetMapping("/turnos/{nombre}")
    public ResponseEntity<String> listarTurnosPorNombre(@PathVariable String patientName) {
        List<Turnos> turnos = ServiceTurnos.listarTurnosPorNombre(patientName);
        return ResponseEntity.ok(patientName);
    }
}


