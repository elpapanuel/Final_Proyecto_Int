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
@Table(name = "Compras")
@SequenceGenerator(name = "Compras_Cod_compra_seq", initialValue = 100, allocationSize = 1)
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Compras_Cod_compra_seq")
	private int Cod_compra;
	
	@Column(name = "D_compra", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date D_compra;
	
	
	@ManyToOne()
	@JoinColumn(name = "Num_DNI_trabajador", nullable = false)
	private Trabajador Trabajador;
	
	
	@OneToMany(mappedBy = "compra", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private  List<DetalleCompra> DetalleCompras;


	





	public Compra() {
		super();
		DetalleCompras= new ArrayList<DetalleCompra>();
	}





	public List<DetalleCompra> getDetalleCompras() {
		return DetalleCompras;
	}





	public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
		DetalleCompras = detalleCompras;
	}





	public int getCod_compra() {
		return Cod_compra;
	}





	public void setCod_compra(int cod_compra) {
		Cod_compra = cod_compra;
	}





	public Date getD_compra() {
		return D_compra;
	}





	public void setD_compra(Date d_compra) {
		D_compra = d_compra;
	}





	public Trabajador getTrabajador() {
		return Trabajador;
	}





	public void setTrabajador(Trabajador trabajador) {
		Trabajador = trabajador;
	}






	
}
