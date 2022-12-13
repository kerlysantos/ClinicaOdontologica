package com.ClinicaOdontologica3.Odontologia.contoller;

import com.ClinicaOdontologica3.Odontologia.model.Odontologos;
import com.ClinicaOdontologica3.Odontologia.service.ServiceOdontologos;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private static final Logger LOGGER = Logger.getLogger(OdontologoController.class);

    private  final ServiceOdontologos serviceOdontologos;

    public OdontologoController(ServiceOdontologos serviceOdontologos){
        this.serviceOdontologos = serviceOdontologos;
    }

@GetMapping("/odontologos1")
    public List<Odontologos> getOdontolos (){
        return serviceOdontologos.getOdontologos();
}

@PostMapping("/nuevoOdontologo")
    public Odontologos crearOdontologo (@RequestBody Odontologos odontologos) {
    LOGGER.info("GUARDANDO UN ODONTOLOGO");
        return serviceOdontologos.CrearOdontologos(odontologos);

    }

    @PutMapping("/actualizarOdontologo/{id}")
    public Odontologos actualizarOdontologo(@PathVariable long id, @RequestBody Odontologos odontologos){
        LOGGER.info("Actualizando  un ODONTOLOGO");
        return serviceOdontologos.actualizarOdontologos(id,odontologos);
    }

    @DeleteMapping("/eliminarOdontologo/{id}")
    public Optional<Odontologos> eliminarOdontologo(@PathVariable long id){
        LOGGER.info("eliminando  un ODONTOLOGO");
        return serviceOdontologos.eliminarOdontologo(id);
    }

    @GetMapping
    public ResponseEntity<List<Odontologos>> buscarTodos() {
        LOGGER.info("buscando  todos los  ODONTOLOGOS");
        return ResponseEntity.ok(serviceOdontologos.buscarTodos());
    }


}
