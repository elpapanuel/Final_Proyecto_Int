package edu.pe.utp.TrabajoFinal.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.model.Cliente;
import edu.pe.utp.TrabajoFinal.repository.ClienteRepository;
import edu.pe.utp.TrabajoFinal.service.ClienteService;

@Service
@Primary
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public JpaRepository<Cliente, Integer> getJpaRepository() {

		return clienteRepository;
	}

	@Override
	public void updateClienteByDNI(int DNI, int user_id) throws Exception {
		clienteRepository.updateClienteByDNI(DNI, user_id);
		
	}

	

}
