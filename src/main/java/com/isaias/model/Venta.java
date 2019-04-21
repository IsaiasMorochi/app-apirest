package com.isaias.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@ApiModel(description = "Informacion de la venta")
@Entity
@Table(name= "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;

	@JsonSerialize(using = ToStringSerializer.class) // ISODate 2019-04-22T05:00:00
	private LocalDateTime fecha;

	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "fk_venta_persona"))
	private Persona persona;

	@Column(name = "importe", nullable = false)
	private double importe;

	@OneToMany(mappedBy = "venta", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleVenta> detalleVenta;

	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public List<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}
	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Venta)) return false;
		Venta venta = (Venta) o;
		return getIdVenta() != null ? getIdVenta().equals(venta.getIdVenta()) : venta.getIdVenta() == null;
	}

	@Override
	public int hashCode() {
		return getIdVenta() != null ? getIdVenta().hashCode() : 0;
	}
}
