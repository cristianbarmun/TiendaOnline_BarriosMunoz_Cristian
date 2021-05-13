package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;

@Service
public interface UsuarioService {

	/**
	 * Guarda el usuario
	 * 
	 * @param producto
	 */
	void guardar(Usuario usuario);

	/**
	 * Recupera la lista completa de usuario
	 * 
	 * @return
	 */
	List<Usuario> obtenerTodosUsuarios();

	/**
	 * Devuelve el usuario correspondiente al id si existe
	 * 
	 * @param id Id del producto
	 * @return
	 */
	Usuario obtenerUsuario(int id);

	/**
	 * Elimina el usuario correspondiente al id
	 * 
	 * @param id Id del producto
	 */
	void eliminar(Integer id);

}
