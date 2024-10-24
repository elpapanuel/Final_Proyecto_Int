package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.entity.DetalleCompra;
import edu.pe.utp.TrabajoFinal.repository.DetalleCompraRepository;
import edu.pe.utp.TrabajoFinal.service.DetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {
	@Autowired
	private DetalleCompraRepository DetalleCompraRepository;

	@Override
	public JpaRepository<DetalleCompra, Integer> getJpaRepository() {

		return DetalleCompraRepository;
	}

	

}
