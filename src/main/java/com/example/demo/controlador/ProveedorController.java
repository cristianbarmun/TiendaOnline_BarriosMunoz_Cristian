package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Proveedores;
import com.example.demo.service.ProveedorServiceImp;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

	@Autowired
	private ProveedorServiceImp proveedorServicio;

	@GetMapping(value = "/listProviders")
	public String listar(Model model) {
		/*
		 * Proveedores cat1 = new Proveedores("Juan Antonio", "C/Guerra", "Zamora",
		 * "Zamora", "605487487", "71044878K", "juann@gmail.com");
		 * 
		 * // guardamos los datos en BBDD categoriaServicio.guardar(cat1);
		 * proveedorServicio.guardar(cat1);
		 */
		List<Proveedores> milista = proveedorServicio.obtenerTodosProveedores();

		model.addAttribute("lista", milista);

		return "/proveedores/listProviders";
	}

	@GetMapping("/new")
	public String crear(Model model) {
		Proveedores proveedor = new Proveedores();
		model.addAttribute("proveedor", proveedor);

		return "/proveedores/new";
	}

	@PostMapping(value = "/new/submit")
	public String guardar(Proveedores proveedor, Model model) {
		proveedorServicio.guardar(proveedor);

		return "redirect:/proveedores/listProviders";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model) {
		Proveedores proveedores = proveedorServicio.obtenerProveedor(id);
		model.addAttribute("proveedor", proveedores);

		return "/proveedores/new";
	}

	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") int idProveedor) {
		proveedorServicio.eliminar(idProveedor);

		return "redirect:/proveedores/listProviders";
	}

}
