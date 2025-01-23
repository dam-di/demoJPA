package org.damx.demojpa.controllers;


import org.apache.coyote.Response;
import org.damx.demojpa.models.Actividad;
import org.damx.demojpa.models.Gasto;
import org.damx.demojpa.models.ResponseModel;
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
    public ResponseEntity<ResponseModel> crearGasto(@RequestBody Gasto gasto) {
        ResponseModel response = new ResponseModel();
        if(gastoService.crearGasto(gasto)){
            response.setMessage("Gasto creado correctamente");
            response.setSuccess(0);
            response.setData(null);
            return ResponseEntity.ok(response);
        }
        response.setMessage("Error al crear gasto");
        response.setSuccess(1);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
}
