package edu.pe.utp.TrabajoFinal.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	private int Num_DNI;

	@NotEmpty(message = "Debe ingresar el nombre de persona")
	@Column(name = "N_persona", nullable = false, length = 150)
	private String N_persona;

	@Max(999999999)
	@Min(900000000)
	@Column(name = "Num_telefono", nullable = false)
	private int Num_telefono;

	@Column(name = "F_estado", nullable = false)
	private boolean F_estado;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Venta> ventas;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CarritoCompra> carritoCompras;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@MapsId("id")
	@JoinColumn(name="user_id",nullable = true)
	private User user;
	
	@Transient
	private String nuevaContra;
	
	@Transient
	private String confirmarNuevaContra;
	
	@Transient
	private String username;
	
	@Transient
	private String password; 
	
	public Cliente() {
		super();
		ventas = new ArrayList<Venta>();
		carritoCompras = new ArrayList<CarritoCompra>();
	}

	public List<CarritoCompra> getCarritoCompras() {
		return carritoCompras;
	}

	public void setCarritoCompras(List<CarritoCompra> carritoCompras) {
		this.carritoCompras = carritoCompras;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public String getConfirmarNuevaContra() {
		return confirmarNuevaContra;
	}

	public void setConfirmarNuevaContra(String confirmarNuevaContra) {
		this.confirmarNuevaContra = confirmarNuevaContra;
	}

	public String getNuevaContra() {
		return nuevaContra;
	}

	public void setNuevaContra(String nuevaContra) {
		this.nuevaContra = nuevaContra;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
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

	public int getNum_DNI() {
		return Num_DNI;
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

	public boolean isF_estado() {
		return F_estado;
	}

	public void setF_estado(boolean f_estado) {
		F_estado = f_estado;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(F_estado, N_persona, Num_DNI, Num_telefono, carritoCompras, ventas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return F_estado == other.F_estado && Objects.equals(N_persona, other.N_persona) && Num_DNI == other.Num_DNI
				&& Num_telefono == other.Num_telefono && Objects.equals(carritoCompras, other.carritoCompras)
				&& Objects.equals(ventas, other.ventas);
	}

}
