package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Rol;

@Service
public interface RolService {

	/**
	 * Guarda el Rol
	 * 
	 * @param producto
	 */
	void guardar(Rol rol);

	/**
	 * Recupera la lista completa de Roles
	 * 
	 * @return
	 */
	List<Rol> obtenerTodosRoles();

	/**
	 * Devuelve el Rol correspondiente al id si existe
	 * 
	 * @param id Id del Rol
	 * @return
	 */
	Rol obtenerRol(int id);

	/**
	 * Elimina el Rol correspondiente al id
	 * 
	 * @param id Id del Rol
	 */
	void eliminar(Integer id);
}
