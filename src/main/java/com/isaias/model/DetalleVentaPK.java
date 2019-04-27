package com.isaias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class DetalleVentaPK implements Serializable {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "fk_dventa_venta"))
    private Venta venta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "fk_dventa_producto"))
    private Producto producto;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleVentaPK)) return false;

        DetalleVentaPK that = (DetalleVentaPK) o;

        if (getVenta() != null ? !getVenta().equals(that.getVenta()) : that.getVenta() != null) return false;
        return getProducto() != null ? getProducto().equals(that.getProducto()) : that.getProducto() == null;
    }

    @Override
    public int hashCode() {
        int result = getVenta() != null ? getVenta().hashCode() : 0;
        result = 31 * result + (getProducto() != null ? getProducto().hashCode() : 0);
        return result;
    }
}
