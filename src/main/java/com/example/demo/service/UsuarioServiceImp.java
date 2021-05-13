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
	public void eliminar(Integer id) {
		usuarioRepository.deleteById(id);	
	}
}