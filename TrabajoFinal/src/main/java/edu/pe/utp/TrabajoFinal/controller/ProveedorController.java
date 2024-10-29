package edu.pe.utp.TrabajoFinal.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import edu.pe.utp.TrabajoFinal.entity.Proveedor;
import edu.pe.utp.TrabajoFinal.security.MyUserDetails;
import edu.pe.utp.TrabajoFinal.service.ProveedorService;


@Controller
@RequestMapping("/oulala/proveedor/")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;

	@RequestMapping("nuevo")
	public String goNew(Model model,@ModelAttribute("nuevoProveedor") Proveedor proveedor) {
		try {
			proveedor.setF_estado(true);
			
			proveedorService.create(proveedor);
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/oulala/proveedor/manteminientoProveedores";
	}
	
	
	@RequestMapping("editar")
	public String goEdit(Model model,@ModelAttribute("editarProveedor") Proveedor proveedor) {
		try {
			
			Optional<Proveedor>searchProveedor = proveedorService.findById(proveedor.getCod_proveedor());
			
			searchProveedor.get().setN_proveedor(proveedor.getN_proveedor());
			searchProveedor.get().setT_email(proveedor.getT_email());
			searchProveedor.get().setNum_proveedor(proveedor.getNum_proveedor());
			proveedorService.update(searchProveedor.get());
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/oulala/proveedor/manteminientoProveedores";
	}
	
	@RequestMapping("eliminar")
	public String goDelete(Model model,@ModelAttribute("eliminarProveedor") Proveedor proveedor) {
		try {
			proveedorService.deleteById(proveedor.getCod_proveedor());
			
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/oulala/proveedor/manteminientoProveedores";
	}
	
	@RequestMapping("manteminientoProveedores")
	public String goList(Model model,Authentication authentication) {
		try {
			
			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
			model.addAttribute("listaProveedores", proveedorService.getAll());
			
			model.addAttribute("nuevoProveedor", new Proveedor());
			model.addAttribute("editarProveedor", new Proveedor());
			model.addAttribute("eliminarProveedor", new Proveedor());
			model.addAttribute("nombreUsuario", userSession.getUser().getTrabajador().getN_persona());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "proveedor/mantenimiento-proveedores";
	}


}
