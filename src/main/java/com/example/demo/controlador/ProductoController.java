package com.example.demo.controlador;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoServiceImp;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoServiceImp productoServicio;// = new ProductoServiceImp();

	@GetMapping(value = "/listProducts")
	public String listar(Model model) {
		/*
		 * Producto product1 = new Producto(1, 2, "Helado de naranja", "Helado rico",
		 * 12.2, 3, new Date(), new Date(), 7.0f); Producto product2 = new Producto(2,
		 * 2, "Helado de melocoton", "Helado rico", 11.2, 2, new Date(), new Date(),
		 * 11.6f); Producto product3 = new Producto(3, 2, "Helado de sandía",
		 * "Helado rico", 4.2, 5, new Date(), new Date(), 21.2f);
		 * 
		 * // guardamos los datos en BBDD productoServicio.guardar(product1);
		 * productoServicio.guardar(product2); productoServicio.guardar(product3);
		 */
		List<Producto> milista = productoServicio.obtenerTodosProductos();

		model.addAttribute("lista", milista);

		return "/productos/listProducts";
	}

	@GetMapping("/new")
	public String crear(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);

		return "/productos/new";
	}

	@PostMapping(value = "/new/submit")
	public String guardar(Producto producto, Model model) {
		productoServicio.guardar(producto);

		return "redirect:/productos/listProducts";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model) {
		Producto producto = productoServicio.obtenerProducto(id);
		model.addAttribute("producto", producto);

		return "/productos/new";
	}

	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") int idProducto) {
		productoServicio.eliminar(idProducto);

		return "redirect:/productos/listProducts";
	}

}
