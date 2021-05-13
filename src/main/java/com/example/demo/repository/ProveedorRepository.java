package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Proveedores;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedores, Integer>{
	public Proveedores findById(int id);
}
