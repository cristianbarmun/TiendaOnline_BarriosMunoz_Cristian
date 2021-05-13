package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.service.RolServiceImp;

@Controller
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RolServiceImp rolServicio;

	@GetMapping(value = "/listRoles")
	public String listar(Model model) {
		/*
		 * Rol rol1=new Rol(1, "Administrador"); Rol rol2=new Rol(2, "Invitado");
		 * 
		 * // guardamos los datos en BBDD rolServicio.guardar(rol1);
		 * rolServicio.guardar(rol2);
		 */
		List<Rol> milista = rolServicio.obtenerTodosRoles();

		model.addAttribute("lista", milista);

		return "/roles/listRoles";
	}

	@GetMapping("/new")
	public String crear(Model model) {
		Rol rol = new Rol();
		model.addAttribute("role", rol);

		return "/roles/new";
	}

	@PostMapping(value = "/new/submit")
	public String guardar(Rol rol, Model model) {
		rolServicio.guardar(rol);

		return "redirect:/roles/listRoles";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model) {
		Rol rol = rolServicio.obtenerRol(id);
		model.addAttribute("role", rol);

		return "/roles/new";
	}
	
	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") int idRol) {
		rolServicio.eliminar(idRol);

		return "redirect:/roles/listRoles";
	}

}
