package com.hulkStore.entidades.java;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {
	/**
	 * Atributo que contiene la serialización de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que determina el id del producto
	 */
	private Long id;

	/**
	 * Atributo que determina el nombre del producto
	 */
	private String nombre;

	/**
	 * Atributo que determina la descripción del producto
	 */
	private String descripcion;

	/**
	 * 
	 * @return the id
	 */
	@Id
	@SequenceGenerator(name = "INFO_PRODUCTO_ID_GENERATOR", sequenceName = "SEC_RAD_INFO_PRODUCTO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INFO_PRODUCTO_ID_GENERATOR")
	@Column(name = "ID_PRODUCTO")
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
