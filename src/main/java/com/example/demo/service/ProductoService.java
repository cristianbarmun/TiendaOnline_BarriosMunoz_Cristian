package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;

@Service
public interface ProductoService {

	/**
	 * Guarda el producto
	 * 
	 * @param producto
	 */
	void guardar(Producto producto);

	/**
	 * Recupera la lista completa de productos
	 * 
	 * @return
	 */
	List<Producto> obtenerTodosProductos();

	/**
	 * Devuelve el producto correspondiente al id si existe
	 * 
	 * @param id Id del producto
	 * @return
	 */
	Producto obtenerProducto(int id);

	/**
	 * Elimina el producto correspondiente al id
	 * 
	 * @param id Id del producto
	 */
	void eliminar(Integer id);

}
