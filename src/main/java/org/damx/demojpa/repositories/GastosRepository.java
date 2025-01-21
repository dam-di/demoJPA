package org.damx.demojpa.repositories;

import org.damx.demojpa.models.Gasto;
import org.damx.demojpa.models.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastosRepository extends JpaRepository<Gasto, Long> {

}
