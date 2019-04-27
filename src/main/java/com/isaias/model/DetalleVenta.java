package com.isaias.model;


import javax.persistence.*;

@Entity
@IdClass(DetalleVentaPK.class)
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleVenta;

	@Id
	private Venta venta;

	@Id
	private Producto producto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
