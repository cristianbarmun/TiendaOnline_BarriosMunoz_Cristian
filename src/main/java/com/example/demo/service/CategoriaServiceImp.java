package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void guardar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> obtenerTodosCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria obtenerCategoria(int id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		categoriaRepository.deleteById(id);
	}
}
