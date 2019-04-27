package com.isaias.service;

import com.isaias.dto.VentaListaDetalleDTO;
import com.isaias.model.DetalleVenta;
import com.isaias.model.Venta;

import java.util.List;

public interface IVentaService extends ICRUD<Venta> {

    Venta registrarTransaccional(VentaListaDetalleDTO ventaDTO);
}
