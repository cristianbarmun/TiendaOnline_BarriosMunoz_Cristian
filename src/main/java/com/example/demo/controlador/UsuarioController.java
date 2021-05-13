package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServiceImp;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImp usuarioServicio;// = new UsuarioServiceImp();

	@GetMapping(value = "/listUsers")
	public String listar(Model model) {
		/*
		 * Usuario usu1 = new Usuario(1, 2, "pepe@gmail.com", "123", "Pepe",
		 * "Rodríguez", "Sanz", "C/Alegría", "Salamanca", "Salamanca", "123456789",
		 * "12345678J"); Usuario usu2 = new Usuario(2, 2, "lucia@gmail.com", "1343",
		 * "Lucía", "Pérez", "Alz", "C/Constitución", "Madrid", "Madrid", "12345654",
		 * "45123231Y"); Usuario usu3 = new Usuario(3, 2, "antonio@gmail.com",
		 * "anto123", "Antonio", "Alonso", "Ann", "C/Estrecha", "Cádiz", "Cádiz",
		 * "26548721", "56445123H");
		 * 
		 * // guardamos los datos en BBDD usuarioServicio.guardar(usu1);
		 * usuarioServicio.guardar(usu2); usuarioServicio.guardar(usu3);
		 */

		List<Usuario> milista = usuarioServicio.obtenerTodosUsuarios();

		model.addAttribute("lista", milista);

		return "/usuario/listUsers";
	}

	@GetMapping("/new")
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);

		return "/usuario/new";
	}

	@PostMapping(value = "/new/submit")
	public String guardar(Usuario usuario, Model model) {
		usuarioServicio.guardar(usuario);

		return "redirect:/usuario/listUsers";
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model) {
		Usuario usuario = usuarioServicio.obtenerUsuario(id);
		model.addAttribute("usuario", usuario);

		return "/usuario/new";
	}

	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") int idUsuario) {
		usuarioServicio.eliminar(idUsuario);

		return "redirect:/usuario/listUsers";
	}

}
