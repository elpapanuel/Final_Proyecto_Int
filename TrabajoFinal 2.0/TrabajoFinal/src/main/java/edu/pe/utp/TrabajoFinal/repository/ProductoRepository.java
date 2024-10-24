package edu.pe.utp.TrabajoFinal.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pe.utp.TrabajoFinal.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query(value="select*from productos order by cod_producto desc limit 6",nativeQuery = true)
	List<Producto> getListEightProducts() throws Exception;
	
}
