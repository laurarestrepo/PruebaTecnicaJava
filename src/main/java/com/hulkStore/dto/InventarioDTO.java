package com.hulkStore.dto;

import java.io.Serializable;

import com.hulkStore.entidades.java.Producto;

public class InventarioDTO implements Serializable {
	/**
	 * Atributo que contiene la serialización de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que determina el id del inventario
	 */
	private Long id;

	/**
	 * Atributo que determina el id del inventario
	 */
	private Long idProducto;

	/**
	 * Atributo que determina el stock del producto
	 */
	private Long stock;

	/**
	 * 
	 * @return the id
	 */

	public Long getId() {
		return id;
	}

	public InventarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventarioDTO(Long id, Long idProducto, Long stock) {
		super();
		this.id = id;
		this.setIdProducto(idProducto);
		this.setStock(stock);
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

}
