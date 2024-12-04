package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.model.Producto;
import edu.pe.utp.TrabajoFinal.repository.ProductoRepository;
import edu.pe.utp.TrabajoFinal.service.ProductoService;

@Service
@Primary
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository ProductoRepository;

	@Override
	public JpaRepository<Producto, Integer> getJpaRepository() {

		return ProductoRepository;
	}

	@Override
	public List<Producto> getListEightProducts() throws Exception {
	
		return ProductoRepository.getListEightProducts();
	}

	

}
