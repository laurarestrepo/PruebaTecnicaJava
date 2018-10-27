package com.hulkStore.dto;

import java.io.Serializable;

import com.hulkStore.entidades.java.Producto;

public class ProductoDTO implements Serializable {
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
	 * Atributo que determina el stock del producto
	 */
	private String stock;

	/**
	 * 
	 * @return the id
	 */

	public Long getId() {
		return id;
	}

	public ProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ProductoDTO(Long id, String nombre, String descripcion, String stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
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

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

}
