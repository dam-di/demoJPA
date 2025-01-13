package org.damx.demojpa.controllers;

import org.damx.demojpa.models.Pasaporte;
import org.damx.demojpa.models.Persona;
import org.damx.demojpa.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public ResponseEntity<Pasaporte> crearPasaporte(@RequestBody Pasaporte pasaporte) {
        return ResponseEntity.ok(personaService.savePassport(pasaporte));
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.save(persona));
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
