package com.hulkStore.dto;

import java.io.Serializable;
import java.util.Date;

import com.hulkStore.entidades.java.EntradaSalida;
import com.hulkStore.entidades.java.Producto;

public class EntradaSalidaDTO implements Serializable {
	/**
	 * Atributo que contiene la serialización de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que determina el id del inventario
	 */
	private Long id;

	/**
	 * Atributo que determina el id del producto
	 */
	private Producto producto;

	/**
	 * Atributo que determina la cantidad de compra o venta del producto
	 */
	private Long cantidad;
	/**
	 * Atributo que determina el tipo de operacion que se está realizando si es
	 * entrada o salida
	 */
	private Boolean tipo;

	/**
	 * Atributo que determina la cantidad de compra o venta del producto
	 */

	private Date fecha;

	/**
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Constructor de la clase
	 */
	public EntradaSalidaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntradaSalidaDTO(EntradaSalida entradaSalida) {
		super();
		this.id = entradaSalida.getId();
		this.producto = entradaSalida.getIdProducto();
		this.cantidad = entradaSalida.getCantidad();
		this.tipo = entradaSalida.getTipo();
		this.fecha=entradaSalida.getFecha();
	}

	/**
	 * @return the idProducto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param idProducto
	 *            the idProducto to set
	 */
	public void setIdProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the tipo
	 */
	public Boolean getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
