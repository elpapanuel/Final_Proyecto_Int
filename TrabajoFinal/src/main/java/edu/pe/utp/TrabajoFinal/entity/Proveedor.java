package edu.pe.utp.TrabajoFinal.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Proveedor")
@SequenceGenerator(name = "Proveedor_Cod_proveedor_seq", initialValue = 100, allocationSize = 1)
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Proveedor_Cod_proveedor_seq")
	private int Cod_proveedor;
	
	@NotEmpty(message = "Debe ingresar el nombre del proveedor")
	@Column(name = "N_proveedor", nullable = false, length = 150)
	private String N_proveedor;
	
	@NotEmpty(message = "Debe ingresar el email")
	@Column(name = "T_email", nullable = false, length = 150)
	private String T_email;
	
	
	@Column(name = "Num_proveedor", nullable = false)
	private int Num_proveedor;
	
	@Column(name = "F_estado", nullable = false)
	private boolean F_estado;
	
	@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<DetalleCompra> DetalleCompras;

	

	
	
	public boolean isF_estado() {
		return F_estado;
	}

	public void setF_estado(boolean f_estado) {
		F_estado = f_estado;
	}

	public Set<DetalleCompra> getDetalleCompras() {
		return DetalleCompras;
	}

	public void setDetalleCompras(Set<DetalleCompra> detalleCompras) {
		DetalleCompras = detalleCompras;
	}

	public int getCod_proveedor() {
		return Cod_proveedor;
	}

	public void setCod_proveedor(int cod_proveedor) {
		Cod_proveedor = cod_proveedor;
	}

	public String getN_proveedor() {
		return N_proveedor;
	}

	public void setN_proveedor(String n_proveedor) {
		N_proveedor = n_proveedor;
	}

	public String getT_email() {
		return T_email;
	}

	public void setT_email(String t_email) {
		T_email = t_email;
	}

	public int getNum_proveedor() {
		return Num_proveedor;
	}

	public void setNum_proveedor(int num_proveedor) {
		Num_proveedor = num_proveedor;
	}

	
	
}
