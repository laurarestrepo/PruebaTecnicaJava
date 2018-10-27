package com.hulkStore.rest.services;

import java.util.Date;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hulkStore.dto.EntradaSalidaDTO;
import com.hulkStore.dto.ProductoDTO;
import com.hulkStore.entidades.java.EntradaSalida;
import com.hulkStore.entidades.java.Inventario;
import com.hulkStore.entidades.java.Producto;

@Path("/InventarioRest")
public class InventarioRest {
	/**
	 * atributo para almacenar el EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * método de prueba
	 * 
	 * @return
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/mensaje")
	public Response MENSAJE() {
		return Response.ok("Prueba").build();
	}

	/**
	 * Servicio encargado de consultar la lista de productos con el stock
	 * 
	 * @param filaInicio
	 * @param filaFin
	 * @return lista de productos
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Path("/listarProductos")
	@Produces(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProductoDTO> listarProductos(
			@QueryParam("filaInicio") Integer filaInicio,
			@QueryParam("filaFin") Integer filaFin) {
		Query query = entityManager
				.createQuery("SELECT new com.hulkstore.dto.ProductoDTO( producto.id, producto.nombre, "
						+ "producto.descripcion, inv.stock) FROM Producto producto "
						+ "JOIN FETCH Inventario inv WHERE 1=1 and  producto.id ="
						+ "inv.idProducto order by producto.nombre ");
		query.setFirstResult(filaInicio);
		query.setMaxResults(filaFin);

		return (List<ProductoDTO>) query.getResultList();

	}

	/**
	 * Servicio encargado de almacenar los productos
	 * 
	 * @param productoDTO
	 * @throws Exception
	 */
	@POST
	@Path("/adicionarProducto")
	@Consumes(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionarProducto(ProductoDTO productoDTO) throws Exception {
		try {
			System.out.println("Inicio método: adicionarProducto");
			String mensaje = validarProducto(productoDTO);
			if (mensaje == "Ya existe un producto con ese nombre"
					+ productoDTO.getNombre()) {
				throw new Exception(mensaje);
			}
			Producto producto = convertirDtoToEntidad(productoDTO);
			entityManager.persist(producto);
			System.out.println("Inicio método: adicionarProducto");

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	/**
	 * Método encargado de verificar si en base de datos ya existe un producto
	 * con ese nombre
	 * 
	 * @param productoDTO
	 * @return
	 * @throws Exception
	 */
	private String validarProducto(ProductoDTO productoDTO) throws Exception {
		String mensaje = "";

		try {
			Query query = entityManager
					.createQuery("SELECT (COUNT(p.id)) FROM Producto p WHERE 1=1 and UPPER(p.nombre)= :NOMBRE");
			query.setParameter("NOMBRE", productoDTO.getNombre().toUpperCase());

			if ((Long) query.getSingleResult() != 0) {

				mensaje = "Ya existe un producto con ese nombre"
						+ productoDTO.getNombre();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}

		return mensaje;
	}

	/**
	 * Método encargado de convertir el DTO de PRoducto a entidad
	 * 
	 * @param productoDTO
	 * @return Producto
	 */
	private Producto convertirDtoToEntidad(ProductoDTO productoDTO) {
		Producto producto = new Producto();
		producto.setId(productoDTO.getId());
		producto.setNombre(productoDTO.getNombre());
		producto.setDescripcion(productoDTO.getDescripcion());
		return producto;
	}

	/**
	 * Metodo encargado de adicionar una venta o registro de producto y aumentar
	 * o disminuir al stock
	 * 
	 * @param entradaSalidaDTO
	 * @throws Exception
	 */
	@POST
	@Path("/adicionarEntradaSalida")
	@Consumes(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionarEntradaSalida(EntradaSalidaDTO entradaSalidaDTO)
			throws Exception {
		try {
			System.out.println("Inicio método: adicionarEntradaSalida");
			EntradaSalida entradaSalida = convertirDtoToEntidadES(entradaSalidaDTO);
			// indica que es una entrada y se debe aumentar el stock
			Inventario inventario = consultarInventarioProducto(entradaSalida
					.getIdProducto());
			if (entradaSalida.getTipo() == true) {
				inventario.setStock(inventario.getStock()
						+ entradaSalida.getCantidad());
			} else {
				inventario.setStock(inventario.getStock()
						- entradaSalida.getCantidad());

			}
			// actualiza el inventario
			entityManager.persist(inventario);
			// adiciona la E/S
			entityManager.persist(entradaSalida);
			System.out.println("Inicio método: adicionarEntradaSalida");

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	/**
	 * Método encargado de consultar el inventario para actualizar el stock
	 * 
	 * @param producto
	 * @return Inventario
	 */
	private Inventario consultarInventarioProducto(Producto producto) {

		try {
			Query consulta = this.entityManager
					.createQuery("select inv from Inventario where inv.idProducto = :ID_PRODUCTO");
			consulta.setParameter("ID_PRODUCTO", producto.getId());
			Inventario inventario = (Inventario) consulta.getSingleResult();
			return inventario;

		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * Metodo encargado de convertir el dto a entidad para poder almacenar en la
	 * base de datos
	 * 
	 * @param entradaSalidaDTO
	 * @return EntradaSalida
	 */
	private EntradaSalida convertirDtoToEntidadES(
			EntradaSalidaDTO entradaSalidaDTO) {
		EntradaSalida entradaSalida = new EntradaSalida();
		entradaSalida.setIdProducto(entradaSalidaDTO.getProducto());
		entradaSalida.setCantidad(entradaSalidaDTO.getCantidad());
		entradaSalida.setTipo(entradaSalidaDTO.getTipo());
		entradaSalida.setFecha(new Date());

		return entradaSalida;
	}
}
