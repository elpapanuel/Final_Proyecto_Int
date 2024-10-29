package edu.pe.utp.TrabajoFinal.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.utp.TrabajoFinal.entity.CarritoCompra;
import edu.pe.utp.TrabajoFinal.entity.Cliente;
import edu.pe.utp.TrabajoFinal.entity.DetalleVenta;
import edu.pe.utp.TrabajoFinal.entity.Producto;
import edu.pe.utp.TrabajoFinal.entity.Venta;
import edu.pe.utp.TrabajoFinal.service.CarritoCompraService;
import edu.pe.utp.TrabajoFinal.service.ClienteService;
import edu.pe.utp.TrabajoFinal.service.DetalleVentaService;
import edu.pe.utp.TrabajoFinal.service.ProductoService;
import edu.pe.utp.TrabajoFinal.service.VentaService;

@Controller
@RequestMapping("/oulala/detalleventa/")
public class DetalleVentaController {

	@Autowired
	private DetalleVentaService detalleVentaService;

	@Autowired
	private VentaService ventaService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CarritoCompraService carritoCompraService;

	@RequestMapping("listarProductos")
	public String goListProductos(Model model) {
		try {
			Optional<Cliente> cliente = clienteService.findById(75564214);	
		double totalPagar=0;
			for (CarritoCompra  producto : cliente.get().getCarritoCompras()) {
				totalPagar+=producto.getQ_unidades()*producto.getProducto().getMonto_unitario();
			}
			model.addAttribute("totalPagarCarrito", totalPagar);
			
			
			
		 model.addAttribute("carritoCompras", cliente.get().getCarritoCompras());
		 model.addAttribute("cantidadProductos", cliente.get().getCarritoCompras().size());
		 model.addAttribute("totalPagar", totalPagar);
		 
		 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "producto/carrito-compras";
	}

	@RequestMapping("agregarProductoCarrito")
	public String goAgregarProductoCarrito(Model model, @ModelAttribute("agregarProductoCarrito") Producto producto) {
		try {
			Optional<Cliente> cliente = clienteService.findById(75564214);
			Optional<Producto> nuevoProducto = productoService.findById(producto.getCod_producto());
			
			CarritoCompra carritoCompra= new CarritoCompra(); 

			carritoCompra.setCliente(cliente.get());
			carritoCompra.setProducto(nuevoProducto.get());
			carritoCompra.setQ_unidades(producto.getQ_producto());

			carritoCompraService.create(carritoCompra);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/oulala/producto/listarProductos";
	}
	
	
	
	@RequestMapping("restarProductos/{id}")
	public String gorestarProducto(Model model,@PathVariable("id") Integer id) {
		try {
			Optional<Cliente> cliente = clienteService.findById(75564214);	
		
			Optional<CarritoCompra> productoRestar= carritoCompraService.findById(id);
			
			productoRestar.get().setQ_unidades((productoRestar.get().getQ_unidades()-1));
		
			carritoCompraService.update(productoRestar.get());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/oulala/detalleventa/listarProductos";
	}
	
	@RequestMapping("sumarProductos/{id}")
	public String goSumarProducto(Model model,@PathVariable("id") Integer id) {
		try {
			Optional<Cliente> cliente = clienteService.findById(75564214);	
		
			Optional<CarritoCompra> productoSumar= carritoCompraService.findById(id);
			
			productoSumar.get().setQ_unidades((productoSumar.get().getQ_unidades()+1));
		
			carritoCompraService.update(productoSumar.get());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/oulala/detalleventa/listarProductos";
	}
	
	
	@RequestMapping("eliminarProducto/{id}")
	public String goEliminarProducto(Model model,@PathVariable("id") Integer id) {
		try {
			carritoCompraService.deleteById(id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/oulala/detalleventa/listarProductos";
	}
	
	

}
