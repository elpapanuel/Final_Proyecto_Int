package edu.pe.utp.TrabajoFinal.service;

import java.util.Optional;

import edu.pe.utp.TrabajoFinal.entity.User;



public interface UserService extends CrudService<User, Integer> {
	Optional<User> findByUsername(String username);
	
	Optional<User> findById(int id) throws Exception;
	
	void insert(int user_id,String password,String username) throws Exception;
	
	int getMaxIdUser() throws Exception;
}
