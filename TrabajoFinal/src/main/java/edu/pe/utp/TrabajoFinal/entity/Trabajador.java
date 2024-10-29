package edu.pe.utp.TrabajoFinal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "Trabajadores")
public class Trabajador {

	@Id
	private int Num_DNI;
	
	@NotEmpty(message = "Debe ingresar el nombre de persona")
	@Column(name = "N_persona", nullable = false, length = 150)
	private String N_persona;
	
	@Max(999999999)
	@Min(900000000)
	@Column(name = "Num_telefono", nullable = false)
	private int Num_telefono;
	
	
	@Column(name = "F_trabajador", nullable = false)
	private boolean F_trabajador;
	
	@Column(name = "F_estado", nullable = false)
	private boolean F_estado;
	
	
	@OneToMany(mappedBy = "Trabajador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Compra> compras;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@MapsId("id")
	@JoinColumn(name="user_id",nullable = true)
	private User user;
	
	public Trabajador() {
		super();
		compras = new ArrayList<Compra>();
	}

	
	
	public Trabajador(int num_DNI, @NotEmpty(message = "Debe ingresar el nombre de persona") String n_persona,
			@Max(999999999) @Min(900000000) int num_telefono, boolean f_trabajador, boolean f_estado,
			List<Compra> compras) {
		super();
		Num_DNI = num_DNI;
		N_persona = n_persona;
		Num_telefono = num_telefono;
		F_trabajador = f_trabajador;
		F_estado = f_estado;
		this.compras = compras;
	
	}

	public int getNum_DNI() {
		return Num_DNI;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setNum_DNI(int num_DNI) {
		Num_DNI = num_DNI;
	}

	public String getN_persona() {
		return N_persona;
	}

	public void setN_persona(String n_persona) {
		N_persona = n_persona;
	}

	public int getNum_telefono() {
		return Num_telefono;
	}

	public void setNum_telefono(int num_telefono) {
		Num_telefono = num_telefono;
	}

	public boolean isF_trabajador() {
		return F_trabajador;
	}

	public void setF_trabajador(boolean f_trabajador) {
		F_trabajador = f_trabajador;
	}

	public boolean isF_estado() {
		return F_estado;
	}

	public void setF_estado(boolean f_estado) {
		F_estado = f_estado;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	
	
	
	
	
	
}
