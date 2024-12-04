package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.model.User;
import edu.pe.utp.TrabajoFinal.repository.UserRepository;
import edu.pe.utp.TrabajoFinal.service.UserService;

@Service
@Primary
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public JpaRepository<User, Integer> getJpaRepository() {

		return userRepository;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public int getMaxIdUser() throws Exception {
		
		return  userRepository.getMaxIdUser();
	}

	@Override
	public Optional<User> findById(int id) throws Exception {
		return  userRepository.findById(id);
	}

	@Override
	public void insert(int user_id, String password, String username) throws Exception {
		userRepository.insert(user_id, password, username);
		
	}

}
