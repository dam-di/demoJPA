package org.damx.demojpa.repositories;

import org.damx.demojpa.models.Actividad;
import org.damx.demojpa.models.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    Optional<List<Actividad>> findByPersona_Id(Long id);
}
