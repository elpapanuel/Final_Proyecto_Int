package edu.pe.utp.TrabajoFinal.service;

import java.util.List;
import java.util.Optional;

import edu.pe.utp.TrabajoFinal.entity.Authority;
import edu.pe.utp.TrabajoFinal.entity.User;




public interface AuthorityService extends CrudService<Authority, Integer> {

	List<Authority> findByUser(User user);
	
}
