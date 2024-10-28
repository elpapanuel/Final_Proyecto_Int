package edu.pe.utp.TrabajoFinal.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import edu.pe.utp.TrabajoFinal.entity.CarritoCompra;
import edu.pe.utp.TrabajoFinal.entity.Cliente;
import edu.pe.utp.TrabajoFinal.entity.DetalleVenta;
import edu.pe.utp.TrabajoFinal.entity.Venta;
import edu.pe.utp.TrabajoFinal.security.MyUserDetails;
import edu.pe.utp.TrabajoFinal.service.CarritoCompraService;
import edu.pe.utp.TrabajoFinal.service.ClienteService;
import edu.pe.utp.TrabajoFinal.service.DetalleVentaService;
import edu.pe.utp.TrabajoFinal.service.VentaService;


@Controller
@RequestMapping("/oulala/venta/")
public class VentaController {

	@Autowired
	VentaService ventaService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private DetalleVentaService detalleVentaService;
	
	@Autowired
	private CarritoCompraService carritoCompraService;
	
	@RequestMapping("nuevo")
	public String goListProductos(Model model, Authentication authentication) {
		try {
			MyUserDetails userSession = (MyUserDetails) authentication.getPrincipal();
			// USAMOS UN USUARIO ESTATICO PORQUE AUN NO SE IMPLEMENTE SECURITY
			 Optional<Cliente> cliente=clienteService.findById(userSession.getUser().getCliente().getNum_DNI()); 
			int cod_venta=ventaService.getMaxCod();
			
			List<CarritoCompra>carritoCompras = cliente.get().getCarritoCompras();
		
			Venta venta = new Venta();
			
			
			venta.setCod_venta(cod_venta);
			venta.setCliente(cliente.get());
			venta.setD_venta(new Date());
			
			ventaService.create(venta);
			
			for (CarritoCompra carritoCompra : carritoCompras) {
				DetalleVenta detalleVenta= new DetalleVenta();
				detalleVenta.setVenta(venta);
				detalleVenta.setProducto(carritoCompra.getProducto());
				detalleVenta.setQ_unidades(carritoCompra.getQ_unidades());
				
				detalleVentaService.create(detalleVenta);
			}
			
			carritoCompraService.deleteByIdCustomer(cliente.get().getNum_DNI());
			
		 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/oulala/detalleventa/listarProductos";
	}


}
