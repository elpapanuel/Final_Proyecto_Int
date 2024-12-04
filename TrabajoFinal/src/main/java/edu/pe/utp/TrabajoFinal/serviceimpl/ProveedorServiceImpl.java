package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.model.Proveedor;
import edu.pe.utp.TrabajoFinal.repository.ProveedorRepository;
import edu.pe.utp.TrabajoFinal.service.ProveedorService;

@Service
@Primary
public class ProveedorServiceImpl implements ProveedorService {
	@Autowired
	private ProveedorRepository ProveedorRepository;

	@Override
	public JpaRepository<Proveedor, Integer> getJpaRepository() {

		return ProveedorRepository;
	}

	

}
