package org.damx.demojpa.controllers;

import org.damx.demojpa.models.Actividad;
import org.damx.demojpa.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearActividad(@RequestBody Actividad actividad) {
        if(actividadService.crearActividad(actividad)){
            return ResponseEntity.ok("Actividad creada correctamente");
        }
        return ResponseEntity.ok("Completa todos los campos");
    }

    @GetMapping("/buscarPorIdPersona/{idPersona}")
    public ResponseEntity<List<Actividad>> buscarPorIdPersona(@PathVariable Long idPersona) {
        List<Actividad> listaActividades = actividadService.buscarPorIdPersona(idPersona);
        return ResponseEntity.ok(listaActividades);
    }
}
