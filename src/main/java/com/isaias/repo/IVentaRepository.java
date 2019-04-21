package com.isaias.repo;

import com.isaias.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Integer> {
}
