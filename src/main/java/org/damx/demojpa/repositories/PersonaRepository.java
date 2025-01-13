package org.damx.demojpa.repositories;

import org.damx.demojpa.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByNombre(String nombre);
    Persona findByCorreo(String email);
    List<Persona> findByNombreContainingIgnoreCase(String nombre);
    List<Persona> findByFechaNacimientoBetween(LocalDate fecha1, LocalDate fecha2);
}
