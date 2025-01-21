package org.damx.demojpa.controllers;


import org.damx.demojpa.models.Actividad;
import org.damx.demojpa.models.Gasto;
import org.damx.demojpa.services.ActividadService;
import org.damx.demojpa.services.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gastos")
public class GastosController {

    @Autowired
    private GastoService gastoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearActividad(@RequestBody Gasto gasto) {
        if(gastoService.crearGasto(gasto)){
            return ResponseEntity.ok("Gasto creado correctamente");
        }
        return ResponseEntity.ok("Completa todos los campos");
    }
}
