package edu.pe.utp.TrabajoFinal.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pe.utp.TrabajoFinal.model.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

	@Query(value = " select*from getMaxCod", nativeQuery = true)
	int getMaxCod() throws Exception;
	
}
