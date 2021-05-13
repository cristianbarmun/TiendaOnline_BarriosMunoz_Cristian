package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rol;
import com.example.demo.repository.RolRepository;
@Service
public class RolServiceImp implements RolService {

	@Autowired
	private RolRepository rolRepository;

	@Override
	public void guardar(Rol rol) {
		rolRepository.save(rol);
	}

	@Override
	public List<Rol> obtenerTodosRoles() {
		return rolRepository.findAll();
	}

	@Override
	public Rol obtenerRol(int id) {
		return rolRepository.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		rolRepository.deleteById(id);	
	}
}