package edu.pe.utp.TrabajoFinal.init;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.entity.Cliente;
import edu.pe.utp.TrabajoFinal.entity.Trabajador;
import edu.pe.utp.TrabajoFinal.entity.User;
import edu.pe.utp.TrabajoFinal.entity.Venta;
import edu.pe.utp.TrabajoFinal.repository.ClienteRepository;
import edu.pe.utp.TrabajoFinal.repository.TrabajadorRepository;
import edu.pe.utp.TrabajoFinal.repository.UserRepository;
import edu.pe.utp.TrabajoFinal.service.ClienteService;
import edu.pe.utp.TrabajoFinal.service.UserService;
import edu.pe.utp.TrabajoFinal.service.VentaService;
import edu.pe.utp.TrabajoFinal.types.UserAuthorities;




@Service
public class InitUser implements CommandLineRunner{
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		
		/*
		// USAMOS UN USUARIO ESTATICO PORQUE AUN NO SE IMPLEMENTE SECURITY
			 Optional<Cliente> clienteGlobal=clienteService.findById(75564214); 
			int cod_venta=ventaService.getMaxCod();
					
				Venta preVenta= new Venta();
				
				preVenta.setCod_venta(cod_venta);
				preVenta.setCliente(clienteGlobal.get());
				preVenta.setD_venta(new Date());
			
		*/
		
		
BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
		// DESBLOQUEAR PARA CREAR USUARIOS
	/*	
		Optional<Trabajador> optional= trabajadorRepository.findById(75564214);
		if (optional.isPresent()) {
			Trabajador admin = optional.get();
			User user =new User("admin", bcpe.encode("admin"), admin);
		 user.addAuthority(UserAuthorities.ROLE_ADMIN);
			userRepository.save(user);
		 }
	
		
		
		//BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
				
				// DESBLOQUEAR PARA CREAR USUARIOS
				
				Optional<Cliente> optional1= clienteRepository.findById(75564214);
				if (optional.isPresent()) {
					Cliente cliente = optional1.get();
					User user =new User("cliente", bcpe.encode("contra"), cliente);
				 user.addAuthority(UserAuthorities.ROLE_CUSTOMER);
					userRepository.save(user);
				 }
			*/
		
		
}
}