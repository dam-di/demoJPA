package org.damx.demojpa.controllers;

import org.damx.demojpa.models.Pasaporte;
import org.damx.demojpa.models.Persona;
import org.damx.demojpa.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id) {
        personaService.delete(id);
        return ResponseEntity.ok("Persona eliminada");
    }

    @PostMapping("/crearPasaporte")
    public ResponseEntity<String> crearPasaporte(@RequestBody Pasaporte pasaporte) {
        if(personaService.savePassport(pasaporte)){
            return ResponseEntity.ok("Pasaporte creado");
        }
        return ResponseEntity.ok("El pasaporte ya existe");
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPersona(@RequestBody Persona persona) {
        try {
            Optional<Persona> p = personaService.save(persona);
            if(p.isPresent()) {
                return ResponseEntity.ok("Persona agregada");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("No se pudo crer la persona");
    }

    @GetMapping("/nombre/{nombre}") // END POINT NOMBRE EXACTO
    public ResponseEntity<Persona> obtenerPersona(@PathVariable String nombre) {
        return ResponseEntity.ok(personaService.findByNombre(nombre));
    }

    @GetMapping("/{nombre}") // END POINT PARTE DEL NOMBRE
    public ResponseEntity<List<Persona>> obtenerPersonaByNombreContaining(@PathVariable String nombre) {
        return ResponseEntity.ok(personaService.findByNombreContaining(nombre));
    }

    @GetMapping("/fechas/{fecha1}/{fecha2}")
    public ResponseEntity<List<Persona>> obtenerPersonasEntreFechasNacimiento(@PathVariable LocalDate fecha1,
                                                                              @PathVariable LocalDate fecha2) {
        return ResponseEntity.ok(personaService.findByEntreFechaNacimiento(fecha1, fecha2));
    }


}
