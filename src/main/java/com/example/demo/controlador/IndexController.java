package com.example.demo.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoServiceImp;

@Controller
@RequestMapping("")
public class IndexController {

	@Autowired
	private ProductoServiceImp productoServicio;
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		
		List<Producto> milista = productoServicio.obtenerTodosProductos();

		model.addAttribute("listaProductos", milista);

		return "index";
	}
	
}
