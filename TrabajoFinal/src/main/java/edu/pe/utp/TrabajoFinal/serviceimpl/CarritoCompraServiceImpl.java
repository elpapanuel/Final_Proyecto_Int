package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.utp.TrabajoFinal.model.CarritoCompra;
import edu.pe.utp.TrabajoFinal.repository.CarritoCompraRepository;
import edu.pe.utp.TrabajoFinal.service.CarritoCompraService;

@Service
@Primary
public class CarritoCompraServiceImpl implements CarritoCompraService {
	@Autowired
	private CarritoCompraRepository carritoCompraRepository;

	@Override
	public JpaRepository<CarritoCompra, Integer> getJpaRepository() {

		return carritoCompraRepository;
	}
	
	@Override
	public void deleteByIdCustomer(Integer id) throws Exception {
		carritoCompraRepository.deleteByIdCustomer(id);
		
	}

	

}
