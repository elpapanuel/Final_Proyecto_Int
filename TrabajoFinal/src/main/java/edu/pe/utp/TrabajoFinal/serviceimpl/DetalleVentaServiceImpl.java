package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.model.DetalleVenta;
import edu.pe.utp.TrabajoFinal.repository.DetalleVentaRepository;
import edu.pe.utp.TrabajoFinal.service.DetalleVentaService;

@Service
@Primary
public class DetalleVentaServiceImpl implements DetalleVentaService {
	@Autowired
	private DetalleVentaRepository DetalleVentaRepository;

	@Override
	public JpaRepository<DetalleVenta, Integer> getJpaRepository() {

		return DetalleVentaRepository;
	}

	

}
