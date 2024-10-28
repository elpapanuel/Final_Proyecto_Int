package edu.pe.utp.TrabajoFinal.controller;

import java.util.Base64;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.pe.utp.TrabajoFinal.entity.CarritoCompra;
import edu.pe.utp.TrabajoFinal.entity.Cliente;
import edu.pe.utp.TrabajoFinal.entity.Producto;
import edu.pe.utp.TrabajoFinal.security.MyUserDetails;
import edu.pe.utp.TrabajoFinal.service.ClienteService;
import edu.pe.utp.TrabajoFinal.service.ProductoService;


@Controller
@RequestMapping("/oulala/producto/")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("nuevo")
	public String goNew( @RequestParam("file") MultipartFile file,Model model,@ModelAttribute("nuevoProducto") Producto producto) {
		try {
			producto.setF_estado(true);
			
			String fileName = StringUtils.cleanPath(file.getOriginalFilename()); 
			if (fileName.contains("...")) {
				System.out.println("file no valido");
			}
			
			producto.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			
			productoService.create(producto);
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/oulala/producto/manteminientoProductos";
	}
	
	
	@PostMapping("editar")
	public String goEdit(@RequestParam("file") MultipartFile file,Model model,@ModelAttribute("editarProducto") Producto producto) {
		try {
			
			Optional<Producto>searchProducto = productoService.findById(producto.getCod_producto());
			
			searchProducto.get().setN_producto(producto.getN_producto());
			searchProducto.get().setQ_producto(producto.getQ_producto());
			searchProducto.get().setMonto_unitario(producto.getMonto_unitario());
			String fileName = StringUtils.cleanPath(file.getOriginalFilename()); 
			searchProducto.get().setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			if (fileName.contains("...")) {
				System.out.println("file no valido");
			}
			
			
			
			productoService.update(searchProducto.get());
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/oulala/producto/manteminientoProductos";
	}
	
	@RequestMapping("eliminar")
	public String goDelete(Model model,@ModelAttribute("eliminarProducto") Producto producto) {
		try {
			productoService.deleteById(producto.getCod_producto());
					
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/oulala/producto/manteminientoProductos";
	}
	
	@GetMapping("manteminientoProductos")
	public String goList(Model model,Authentication authentication) {
		try {
			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
			
			model.addAttribute("listaProductos", productoService.getAll());	
			model.addAttribute("nuevoProducto", new Producto());
			model.addAttribute("editarProducto", new Producto());
			model.addAttribute("eliminarProducto", new Producto());
			model.addAttribute("nombreUsuario", userSession.getUser().getTrabajador().getN_persona());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "producto/mantenimiento-productos";
	}


	@GetMapping("listarProductos")
	public String goListProductos(Model model, Authentication authentication) throws Exception {
		try {
			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
			Optional<Cliente> cliente = clienteService.findById(userSession.getUser().getCliente().getNum_DNI());	
			double totalPagar=0;
			for (CarritoCompra  producto : cliente.get().getCarritoCompras()) {
				totalPagar+=producto.getQ_unidades()*producto.getProducto().getMonto_unitario();
			}
			model.addAttribute("totalPagarCarrito", totalPagar);
			model.addAttribute("listaProductos", productoService.getAll());
			model.addAttribute("nombreUsuario", userSession.getUser().getCliente().getN_persona());
		} catch (Exception e) {
			Optional<Cliente> cliente = clienteService.findById(75564214);	
			double totalPagar=0;
			for (CarritoCompra  producto : cliente.get().getCarritoCompras()) {
				totalPagar+=producto.getQ_unidades()*producto.getProducto().getMonto_unitario();
			}
			model.addAttribute("totalPagarCarrito", totalPagar);
			model.addAttribute("listaProductos", productoService.getAll());
			model.addAttribute("nombreUsuario", "");
		}
		return "producto/productos";
	}
	
	
	@GetMapping("detalleProducto/{id}")
	public String goDetalleProducto(Model model,@PathVariable("id") Integer id, Authentication authentication) throws Exception {
		try {
			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
			Optional<Producto>searchProducto = productoService.findById(id);
			Optional<Cliente> cliente = clienteService.findById(userSession.getUser().getCliente().getNum_DNI());	
			double totalPagar=0;
			for (CarritoCompra  producto : cliente.get().getCarritoCompras()) {
				totalPagar+=producto.getQ_unidades()*producto.getProducto().getMonto_unitario();
			}
			model.addAttribute("totalPagarCarrito", totalPagar);
			
			
			
			model.addAttribute("codigoProducto", id);
			model.addAttribute("producto", searchProducto.get());
			model.addAttribute("agregarProductoCarrito", new Producto());
		} catch (Exception e) {
			
			Optional<Producto>searchProducto = productoService.findById(id);
			Optional<Cliente> cliente = clienteService.findById(75564214);	
			double totalPagar=0;
			for (CarritoCompra  producto : cliente.get().getCarritoCompras()) {
				totalPagar+=producto.getQ_unidades()*producto.getProducto().getMonto_unitario();
			}
			model.addAttribute("totalPagarCarrito", totalPagar);
			
			
			
			model.addAttribute("codigoProducto", id);
			model.addAttribute("producto", searchProducto.get());
			model.addAttribute("agregarProductoCarrito", new Producto());
		}
		return "producto/detalle-producto";
	}


}
