package edu.pe.utp.TrabajoFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pe.utp.TrabajoFinal.model.Authority;
import edu.pe.utp.TrabajoFinal.model.User;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

	List<Authority> findByUser(User user);
	
}
