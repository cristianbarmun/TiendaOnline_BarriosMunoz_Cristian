package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;

@Service
public interface CategoriaService {

	/**
	 * Guarda el categoria
	 * 
	 * @param producto
	 */
	void guardar(Categoria categoria);

	/**
	 * Recupera la lista completa de categoria
	 * 
	 * @return
	 */
	List<Categoria> obtenerTodosCategorias();

	/**
	 * Devuelve el categoria correspondiente al id si existe
	 * 
	 * @param id Id del categoria
	 * @return
	 */
	Categoria obtenerCategoria(int id);

	/**
	 * Elimina el categoria correspondiente al id
	 * 
	 * @param id Id del categoria
	 */
	void eliminar(Integer id);

}
