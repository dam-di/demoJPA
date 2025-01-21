package org.damx.demojpa.services;

import org.damx.demojpa.models.Actividad;
import org.damx.demojpa.models.Gasto;
import org.damx.demojpa.repositories.GastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoService {
    @Autowired
    GastosRepository gastosRepository;
    public boolean crearGasto(Gasto gasto) {
        try{
            gastosRepository.save(gasto);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
