package com.hulkStore.entidades.java;

import java.io.Serializable;

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

@Entity
@Table(name = "INVENTARIO")
public class Inventario implements Serializable {
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
	 * Atributo que determina el stock del producto
	 */
	private Long Stock;

	/**
	 * 
	 * @return the id
	 */
	@Id
	@SequenceGenerator(name = "INFO_INVENTARIO_ID_GENERATOR", sequenceName = "SEC_INFO_INVENTARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INFO_INVENTARIO_ID_GENERATOR")
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
	 * @return the stock
	 */
	@Column(name = "STOCK")
	public Long getStock() {
		return Stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(Long stock) {
		Stock = stock;
	}

}
