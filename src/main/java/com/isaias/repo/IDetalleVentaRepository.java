package com.isaias.repo;

import com.isaias.model.DetalleVenta;
import com.isaias.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDetalleVentaRepository extends JpaRepository<Venta, Integer> {

    @Modifying
    @Query(value = "INSERT INTO detalle_venta(id_venta, id_producto, cantidad) VALUES (:idVenta, :idProducto, :cantidad)", nativeQuery = true)
    Integer registrar(@Param("idVenta")Integer idVenta, @Param("idProducto") Integer idProducto, @Param("cantidad") Integer cantidad);
}
