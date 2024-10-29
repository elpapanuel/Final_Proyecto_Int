package edu.pe.utp.TrabajoFinal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "Ventas")
public class Venta {

	@Id
	private int Cod_venta;
	
	@Column(name = "D_venta", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date D_venta;
	
	@ManyToOne()
	@JoinColumn(name = "Num_DNI", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleVenta> DetalleVentas;

	public Venta() {
		super();
		DetalleVentas= new ArrayList<DetalleVenta>();
	}

	
	
	public List<DetalleVenta> getDetalleVentas() {
		return DetalleVentas;
	}



	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		DetalleVentas = detalleVentas;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	

	public int getCod_venta() {
		return Cod_venta;
	}

	public void setCod_venta(int cod_venta) {
		Cod_venta = cod_venta;
	}

	public Date getD_venta() {
		return D_venta;
	}

	public void setD_venta(Date d_venta) {
		D_venta = d_venta;
	}

	

	

	


	
}
