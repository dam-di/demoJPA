package org.damx.demojpa.services;

import org.damx.demojpa.models.Pasaporte;
import org.damx.demojpa.models.Persona;
import org.damx.demojpa.repositories.PasaporteRepository;
import org.damx.demojpa.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasaporteRepository pasaporteRepository;

    public Pasaporte savePassport(Pasaporte pasaporte) {
        return pasaporteRepository.save(pasaporte);
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    public Persona save(Persona persona) {
        if (persona.getPasaporte() != null) {
            persona.getPasaporte().setPersona(persona);
        }
        if (persona.getTelefono() != null) {
            persona.getTelefono().setPersona(persona);
        }
        return personaRepository.save(persona);
    }

    public Persona findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    public Persona findByEmail(String email) {
        return personaRepository.findByCorreo(email);
    }

    public List<Persona> findByNombreContaining(String nombre) {
        return personaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Persona> findByEntreFechaNacimiento(LocalDate fecha1, LocalDate fecha2) {
        return personaRepository.findByFechaNacimientoBetween(fecha1, fecha2);
    }

}
