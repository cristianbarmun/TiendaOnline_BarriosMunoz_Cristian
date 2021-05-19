package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	private static final String MENSAJE = "Usuario y/o Contraseña no válidos";

	@GetMapping("/login")
	public String login(Model model) {
		//model.addAttribute("mensaje", "");
		return "/login/login";
	}

}
