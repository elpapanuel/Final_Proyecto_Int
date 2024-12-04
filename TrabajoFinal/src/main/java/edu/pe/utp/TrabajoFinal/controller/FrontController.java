package edu.pe.utp.TrabajoFinal.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import edu.pe.utp.TrabajoFinal.model.Authority;
import edu.pe.utp.TrabajoFinal.model.CarritoCompra;
import edu.pe.utp.TrabajoFinal.model.Cliente;
import edu.pe.utp.TrabajoFinal.model.Producto;
import edu.pe.utp.TrabajoFinal.model.User;
import edu.pe.utp.TrabajoFinal.security.MyUserDetails;
import edu.pe.utp.TrabajoFinal.service.AuthorityService;
import edu.pe.utp.TrabajoFinal.service.ClienteService;
import edu.pe.utp.TrabajoFinal.service.ProductoService;
import edu.pe.utp.TrabajoFinal.service.UserService;

@Controller
@RequestMapping("/oulala/")
public class FrontController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;

	@GetMapping("login") //
	public String login() {
		return "login";
	}

	@RequestMapping("index")
	public String goNew(Model model, Authentication authentication) throws Exception {
		try {

			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
			if (userSession.getUser().getAuthorityRoleCliente().equals("ROLE_CUSTOMER")) {
				Optional<Cliente> cliente = clienteService.findById(userSession.getUser().getCliente().getNum_DNI());
				double totalPagar = 0;
				for (CarritoCompra producto : cliente.get().getCarritoCompras()) {
					totalPagar += producto.getQ_unidades() * producto.getProducto().getMonto_unitario();
				}
				List<Producto> productos = productoService.getListEightProducts();

				model.addAttribute("productos", productos);
				model.addAttribute("totalPagarCarrito", totalPagar);
				model.addAttribute("nombreUsuario", userSession.getUser().getCliente().getN_persona());
				return "index";
			}

			else {

				Optional<Cliente> cliente = clienteService.findById(userSession.getUser().getCliente().getNum_DNI());
				double totalPagar = 0;
				for (CarritoCompra producto : cliente.get().getCarritoCompras()) {
					totalPagar += producto.getQ_unidades() * producto.getProducto().getMonto_unitario();
				}
				List<Producto> productos = productoService.getListEightProducts();
				model.addAttribute("productos", productos);
				model.addAttribute("totalPagarCarrito", totalPagar);
				model.addAttribute("nombreUsuario", userSession.getUser().getTrabajador().getN_persona());
				return "index";

			}
		} catch (Exception e) {

			double totalPagar = 0;

			List<Producto> productos = productoService.getListEightProducts();
			model.addAttribute("productos", productos);
			model.addAttribute("totalPagarCarrito", totalPagar);

			return "index";
		}

	}

	@RequestMapping("index/login")
	public String goNewGA(Model model, Authentication authentication) throws Exception {
		try {
			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
			if (userSession.getUser().getAuthorityRoleCliente().equals("ROLE_CUSTOMER")) {
				Optional<Cliente> cliente = clienteService.findById(userSession.getUser().getCliente().getNum_DNI());
				double totalPagar = 0;
				for (CarritoCompra producto : cliente.get().getCarritoCompras()) {
					totalPagar += producto.getQ_unidades() * producto.getProducto().getMonto_unitario();
				}
				List<Producto> productos = productoService.getListEightProducts();

				model.addAttribute("productos", productos);
				model.addAttribute("totalPagarCarrito", totalPagar);
				model.addAttribute("nombreUsuario", userSession.getUser().getCliente().getN_persona());
				return "index";
			}

			else {

				Optional<Cliente> cliente = clienteService.findById(userSession.getUser().getCliente().getNum_DNI());
				double totalPagar = 0;
				for (CarritoCompra producto : cliente.get().getCarritoCompras()) {
					totalPagar += producto.getQ_unidades() * producto.getProducto().getMonto_unitario();
				}
				List<Producto> productos = productoService.getListEightProducts();
				model.addAttribute("productos", productos);
				model.addAttribute("totalPagarCarrito", totalPagar);
				model.addAttribute("nombreUsuario", userSession.getUser().getTrabajador().getN_persona());
				return "index";

			}
		} catch (Exception e) {
			double totalPagar = 0;

			List<Producto> productos = productoService.getListEightProducts();
			model.addAttribute("productos", productos);
			model.addAttribute("totalPagarCarrito", totalPagar);

			return "index";
		}

	}

//

	@RequestMapping("register/error")
	public String goRegisterError(Model model) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		try {
			// USER

			model.addAttribute("cliente", new Cliente());
		} catch (Exception e) {

		}

		return "registerError";
	}
	
	@RequestMapping("register")
	public String goRegister(Model model) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		try {
			// USER

			model.addAttribute("cliente", new Cliente());
		} catch (Exception e) {

		}

		return "register";
	}

	@RequestMapping("register/new")
	public String goNewRegister(Model model, @ModelAttribute("cliente") Cliente cliente) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		try {
			Optional<User> usuario=userService.findByUsername(cliente.getUsername());
			if(usuario.isEmpty()) {
			// USER
			String username = cliente.getUsername();
			String password = bcpe.encode(cliente.getPassword());
			int user_id = userService.getMaxIdUser();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setId(user_id);
			userService.create(user);

			Optional<User> userCreated = userService.findById(user_id);
			// Authority
			Authority authority = new Authority();
			authority.setAuthority("ROLE_CUSTOMER");
			authority.setUser(userCreated.get());
			authorityService.create(authority);

			// INVESTOR

			cliente.setF_estado(true);
			cliente.setUser(userCreated.get());
			clienteService.create(cliente);
			clienteService.updateClienteByDNI(cliente.getNum_DNI(), user_id);
			}
			
			else return "redirect:/oulala/register/error" ;
			
			
		} catch (Exception e) {

		}

		return "redirect:/oulala/index/login";
	}
	
	
	@RequestMapping("edit")
	public String goEdit(Model model,Authentication authentication) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
		try {
			// USER

			model.addAttribute("cliente", userSession.getUser().getCliente());
		} catch (Exception e) {

		}

		return "edit";
	}
	
	@RequestMapping("edit/error")
	public String goEditError(Model model,Authentication authentication) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
		try {
			// USER

			model.addAttribute("cliente", userSession.getUser().getCliente());
		} catch (Exception e) {

		}

		return "editError1";
	}
	
	
	@RequestMapping("edit/new")
	public String goNewEdit(Model model, @ModelAttribute("cliente") Cliente cliente,Authentication authentication) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
		try {
			
			if(bcpe.matches(cliente.getPassword(),userSession.getUser().getPassword()) && cliente.getNuevaContra().equals(cliente.getConfirmarNuevaContra()) ) {
			// USER
			String password = bcpe.encode(cliente.getNuevaContra());
			Optional<User> user = userService.findById(userSession.getUser().getId());
			user.get().setPassword(password);

			userService.update(user.get());

			}
			
			else return "redirect:/oulala/edit/error" ;

		} catch (Exception e) {

		}

		return "redirect:/oulala/index/login";
	}
	
	

}
