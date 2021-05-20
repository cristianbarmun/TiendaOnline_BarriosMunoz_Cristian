package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> obtenerTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario obtenerUsuario(int id) {
		return usuarioRepository.findById(id);
	}
	
	@Override
	public Usuario obtenerUsuario(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public void eliminar(Integer id) {
		usuarioRepository.deleteById(id);
	}

	/** Metodo para validar el login */
	public boolean checkLogin(String email, String password) {

		//guardamos el usuario
		Usuario usuario = obtenerUsuario(email);
		boolean correcto = false;

		//si no es nulo
		if (usuario != null) {
			//devolvemos si las credenciales son correctos
			correcto = checkCredentials(usuario, password);

		}
		return correcto;
	}

	/** Metodo para comprobar las credenciales del usuario */
	public static boolean checkCredentials(Usuario usuario, String passwordUser) {

		boolean correcto = false;

		// guardamos la clave introducida por el usuario
		String clave = usuario.getClave();

		// comprobamos que la clave introducida es la misma que la del usuario
		if (passwordUser.equals(clave)) {
			correcto = true;
		}

		return correcto;
	}
}