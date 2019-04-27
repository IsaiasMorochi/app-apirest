package com.isaias.dto;

import com.isaias.model.DetalleVenta;
import com.isaias.model.Producto;
import com.isaias.model.Venta;

import java.util.List;

public class VentaListaDetalleDTO {

    private Venta venta;

    private List<Producto> detalleVenta;

    private int cantidad;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }


    public List<Producto> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<Producto> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
