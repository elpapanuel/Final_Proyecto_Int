package edu.pe.utp.TrabajoFinal.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import edu.pe.utp.TrabajoFinal.entity.Cliente;
import edu.pe.utp.TrabajoFinal.security.MyUserDetails;
import edu.pe.utp.TrabajoFinal.service.ClienteService;


@Controller
@RequestMapping("/oulala/cliente/") //  /oulala/cliente/lista
public class ClienteController {

@Autowired
ClienteService clienteService;

	@RequestMapping("lista")
	public String goRegister(Model model, Authentication authentication) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		try {
			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();

			model.addAttribute("listaUsuarios", clienteService.getAll());
			model.addAttribute("nombreUsuario", userSession.getUser().getTrabajador().getN_persona());
		} catch (Exception e) {

		}

		return "mantenimiento-usuarios";
	}

	


}
