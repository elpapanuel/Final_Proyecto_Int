package edu.pe.utp.TrabajoFinal.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.utp.TrabajoFinal.entity.CarritoCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Integer> {
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "delete from carrito_compras where num_dni=:id ", nativeQuery = true)
	void deleteByIdCustomer(Integer id) throws Exception;
	
}
