package edu.pe.utp.TrabajoFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.pe.utp.TrabajoFinal.types.UserAuthorities;


@Entity
@Table(name = "users", indexes = { @Index(columnList = "username", name = "user_index_username") })
public class User {
	@Id
	@Column(name="user_id")
	private Integer id;

	@NotNull
	@NotBlank
	@Size(max = 40)
	@Column(name = "username", length = 40, nullable = false)
	private String username;
	@NotNull
	@NotBlank
	@Size(max = 60)
	@Column(name = "password", length = 60, nullable = false)
	private String password;

	@NotNull
	@Column(name = "enable")
	private boolean enable;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Authority> authorities;

	@OneToOne(mappedBy="user",orphanRemoval = true)
	private Cliente cliente;
	
	@OneToOne(mappedBy="user",orphanRemoval = true)
	private Trabajador trabajador;

	

	public User() {
		this.enable=true;
		this.authorities=new ArrayList<Authority>();
	}
	
	
	public User(String username, String password) {
		this.username=username;
		this.password=password;
		this.enable=true;
		this.authorities=new ArrayList<Authority>();
	}
	
	public User(String username, String password, Cliente cliente) {
		this.id=cliente.getNum_DNI();
		this.username=username;
		this.password=password;
		this.enable=true;
		this.cliente=cliente;
		this.authorities=new ArrayList<Authority>();
		cliente.setUser(this);
	}
	
	public User(String username, String password, Trabajador trabajador) {
		this.id=trabajador.getNum_DNI();
		this.username=username;
		this.password=password;
		this.enable=true;
		this.trabajador=trabajador;
		this.authorities=new ArrayList<Authority>();
		trabajador.setUser(this);
	}
	
	
	//PARA AGREGAR ROLES 
	public void addAuthority(UserAuthorities auth) {
		Authority authority = new Authority();
		authority.setAuthority(auth.name());
		authority.setUser(this);
		this.authorities.add(authority);
		
	}
	
	

	public User(Integer id, @NotNull @NotBlank @Size(max = 40) String username,
			@NotNull @NotBlank @Size(max = 60) String password, @NotNull boolean enable, List<Authority> authorities,
			Cliente cliente, Trabajador trabajador) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.authorities = authorities;
		this.cliente = cliente;
		this.trabajador = trabajador;
	}


	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public String getAuthorityRoleTrabajador() {
		
		String roleInvestor = new String();
		for (Authority authority : this.authorities) {
			if(authority.getAuthority().equals("ROLE_EMPLOYEE"))
				roleInvestor=authority.getAuthority();	
		}
		
		return roleInvestor;
	}
	
public String getAuthorityRoleAdmin() {
		
		String roleAdmin= new String();
		for (Authority authority : this.authorities) {
			if(authority.getAuthority().equals("ROLE_ADMIN"))
				roleAdmin=authority.getAuthority();	
		}
		
		return roleAdmin;
	}
	


public String getAuthorityRoleCliente() {
	
	String roleCliente= new String();
	for (Authority authority : this.authorities) {
		if(authority.getAuthority().equals("ROLE_CUSTOMER"))
			roleCliente=authority.getAuthority();	
	}
	
	return roleCliente;
}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Trabajador getTrabajador() {
		return trabajador;
	}


	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	

}
