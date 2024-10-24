package edu.pe.utp.TrabajoFinal.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.utp.TrabajoFinal.entity.Cliente;
import edu.pe.utp.TrabajoFinal.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update clientes set user_id=?2\r\n"
			+ "where num_dni=?1",nativeQuery=true)
	void updateClienteByDNI(int DNI,int user_id) throws Exception;
	
	
	
	
	
	
}
