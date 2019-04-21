package com.isaias.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@ApiModel(description = "Informacion del producto")
@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;

	@ApiModelProperty(notes = "Nombre de producto debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 80)
	@Size(min = 3, message = "El nombre del producto debe tener minimo 3 caracteres")
	private String nombre;

	@ApiModelProperty(notes = "Marca del producto debe tener minimo 3 caracteres")
	@Column(name = "marca", nullable = false, length = 50)
	@Size(min = 3, message = "La marca del producto debe tener un minimo de 3 caracteres")
	private String marca;

	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}	
}
