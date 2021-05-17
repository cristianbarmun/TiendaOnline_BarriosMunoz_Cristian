package com.example.demo.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Categoria;
import com.example.demo.model.Usuario;
import com.example.demo.service.CategoriaServiceImp;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaServiceImp categoriaServicio;

	@GetMapping(value = "/listCategorias")
	public String listar(Model model) {
		/*
		 * Categoria cat1 = new Categoria(1, "Salado", "Categoria de helados salados");
		 * Categoria cat2 = new Categoria(2, "Dulce", "Categoria de helados dulces");
		 * Categoria cat3 = new Categoria(3, "Ácido", "Categoria de helados ácidos");
		 * 
		 * // guardamos los datos en BBDD categoriaServicio.guardar(cat1);
		 * categoriaServicio.guardar(cat2); categoriaServicio.guardar(cat3);
		 */
		List<Categoria> milista = categoriaServicio.obtenerTodosCategorias();

		model.addAttribute("listaCategorias", milista);

		return "/categorias/listCategorias";
	}

	@GetMapping("/new")
	public String crear(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);

		return "/categorias/new";
	}

	@PostMapping(value = "/new/submit")
	public String guardar(Categoria categoria, Model model) {
		categoriaServicio.guardar(categoria);

		return "redirect:/categorias/listCategorias";
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model) {
		Categoria categoria = categoriaServicio.obtenerCategoria(id);
		model.addAttribute("categoria", categoria);

		return "/categorias/new";
	}

	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") int idCategoria) {
		categoriaServicio.eliminar(idCategoria);

		return "redirect:/categorias/listCategorias";
	}

}
