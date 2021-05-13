package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Proveedores;
import com.example.demo.repository.ProveedorRepository;

@Service
public class ProveedorServiceImp implements ProveedorService {
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public void guardar(Proveedores proveedores) {
		proveedorRepository.save(proveedores);
	}

	@Override
	public List<Proveedores> obtenerTodosProveedores() {
		return proveedorRepository.findAll();
	}

	@Override
	public Proveedores obtenerProveedor(int id) {
		return proveedorRepository.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		proveedorRepository.deleteById(id);	
	}
}
