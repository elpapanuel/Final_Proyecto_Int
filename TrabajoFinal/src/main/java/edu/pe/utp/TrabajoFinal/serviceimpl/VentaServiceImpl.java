package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.model.Venta;
import edu.pe.utp.TrabajoFinal.repository.VentaRepository;
import edu.pe.utp.TrabajoFinal.service.VentaService;

@Service
@Primary
public class VentaServiceImpl implements VentaService {
	@Autowired
	private VentaRepository VentaRepository;

	@Override
	public JpaRepository<Venta, Integer> getJpaRepository() {

		return VentaRepository;
	}

	@Override
	public int getMaxCod() throws Exception {
		
		return VentaRepository.getMaxCod() ;
	}

	

}
