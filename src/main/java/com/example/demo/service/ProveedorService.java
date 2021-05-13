package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Proveedores;

@Service
public interface ProveedorService {

	/**
	 * Guarda el proveedores
	 * 
	 * @param proveedores
	 */
	void guardar(Proveedores proveedores);

	/**
	 * Recupera la lista completa de proveedores
	 * 
	 * @return
	 */
	List<Proveedores> obtenerTodosProveedores();

	/**
	 * Devuelve el proveedores correspondiente al id si existe
	 * 
	 * @param id Id del proveedores
	 * @return
	 */
	Proveedores obtenerProveedor(int id);

	/**
	 * Elimina el proveedores correspondiente al id
	 * 
	 * @param id Id del proveedores
	 */
	void eliminar(Integer id);
	
}
