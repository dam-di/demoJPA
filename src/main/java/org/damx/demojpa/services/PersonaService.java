package org.damx.demojpa.services;

import org.damx.demojpa.models.Pasaporte;
import org.damx.demojpa.models.Persona;
import org.damx.demojpa.repositories.PasaporteRepository;
import org.damx.demojpa.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasaporteRepository pasaporteRepository;

    public boolean savePassport(Pasaporte pasaporte) {
        try{
            pasaporteRepository.save(pasaporte);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    public Optional<Persona> save(Persona persona) {
        if (persona.getPasaporte() != null) {
            persona.getPasaporte().setPersona(persona);
        }
        if (persona.getTelefono() != null) {
            persona.getTelefono().setPersona(persona);
        }
        try{
            Optional<Persona> p = Optional.of(personaRepository.save(persona));
            return p;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

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

    public Optional<List<Persona>> findPersonas(){
        return personaRepository.findAllBy();
    }

}
