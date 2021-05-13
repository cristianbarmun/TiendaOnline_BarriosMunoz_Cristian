package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
@Service
public class ProductoServiceImp implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public List<Producto> obtenerTodosProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto obtenerProducto(int id) {
		return productoRepository.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		productoRepository.deleteById(id);	
	}

}
