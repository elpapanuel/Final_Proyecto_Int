package edu.pe.utp.TrabajoFinal.service;


import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.utp.TrabajoFinal.entity.CarritoCompra;


public interface CarritoCompraService extends CrudService<CarritoCompra, Integer> {
	@Transactional
	@Modifying
	 void deleteByIdCustomer(Integer id) throws Exception;
}
