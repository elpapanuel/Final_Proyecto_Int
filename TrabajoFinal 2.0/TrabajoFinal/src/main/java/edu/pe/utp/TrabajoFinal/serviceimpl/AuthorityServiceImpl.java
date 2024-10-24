package edu.pe.utp.TrabajoFinal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.pe.utp.TrabajoFinal.entity.Authority;
import edu.pe.utp.TrabajoFinal.entity.User;
import edu.pe.utp.TrabajoFinal.repository.AuthorityRepository;
import edu.pe.utp.TrabajoFinal.service.AuthorityService;


@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public JpaRepository<Authority, Integer> getJpaRepository() {

		return authorityRepository;
	}

	@Override
	public List<Authority> findByUser(User user) {
	
		return authorityRepository.findByUser(user);
	}

}
