package com.hulkStore.entidades.java;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ENTRADA_SALIDA")
public class EntradaSalida implements Serializable {
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
	private Producto idProducto;

	/**
	 * Atributo que determina la cantidad de compra o venta del producto
	 */
	private Long cantidad;
	/**
	 * Atributo que determina el tipo de operacion que se está realizando si es entrada o salida
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
	@Id
	@SequenceGenerator(name = "INFO_ENT_SAL_ID_GENERATOR", sequenceName = "SEC_ENT_SAL_INVENTARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INFO_ENT_SAL_ID_GENERATOR")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	/**
	 * @return the idProducto
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCTO")
	public Producto getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto
	 *            the idProducto to set
	 */
	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the cantidad
	 */
	@Column(name = "CANTIDAD")
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
	@Column(name = "TIPO")
	public Boolean getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fecha
	 */
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
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
