package com.example.demo.controlador;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServiceImp;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioServiceImp usuarioServiceImp;

	private static final String MENSAJE = "Usuario y/o Contraseña no válidos";

	@GetMapping("/login")
	public String login(Model model) {
		// model.addAttribute("mensaje", "");
		return "/login/login";
	}

	@PostMapping("/login/acceso/comprueba")
	public String checkLogin(HttpSession session, Model model, @Valid @RequestParam(required = true) String email,
			@RequestParam(required = true) String password) {

		// comprobamos que el login sea correcto
		boolean login = usuarioServiceImp.checkLogin(email, password);

		// si el login es correcto
		if (login == true) {

			Usuario user = usuarioServiceImp.obtenerUsuario(email);
			session.setAttribute("usuario", user);

			//si todo es correcto, te manda al index
			return "redirect:/";
			
		//si el login no es correcto, te devuelve a la misma ventana	
		} else {
			return "/login/login";
		}
	}

}
