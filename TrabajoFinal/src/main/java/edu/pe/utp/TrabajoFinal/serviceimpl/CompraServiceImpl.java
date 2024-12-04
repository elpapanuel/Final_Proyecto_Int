package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.model.Compra;
import edu.pe.utp.TrabajoFinal.repository.CompraRepository;
import edu.pe.utp.TrabajoFinal.service.CompraService;

@Service
@Primary
public class CompraServiceImpl implements CompraService {
	@Autowired
	private CompraRepository compraRepository;

	@Override
	public JpaRepository<Compra, Integer> getJpaRepository() {

		return compraRepository;
	}

	

}
