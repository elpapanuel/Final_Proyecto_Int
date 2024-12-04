package edu.pe.utp.TrabajoFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.utp.TrabajoFinal.model.Cliente;
import edu.pe.utp.TrabajoFinal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String username);
	
	
	@Query(value="select*from users where user_id=?1",nativeQuery=true)
	Optional<User> findById(int id) throws Exception;
	
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="insert into users values(?1,true,?2,?3)",nativeQuery=true)
	void insert(int user_id,String password,String username) throws Exception;
	
	@Query(value="select*from getMaxIdUser",nativeQuery=true)
	int getMaxIdUser() throws Exception;
}
