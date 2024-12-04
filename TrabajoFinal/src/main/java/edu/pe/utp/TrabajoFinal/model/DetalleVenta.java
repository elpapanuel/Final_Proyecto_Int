package edu.pe.utp.TrabajoFinal.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleVentas")
@SequenceGenerator(name = "DetalleVentas_Cod_detalle_venta_seq", initialValue = 100, allocationSize = 1)
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleVentas_Cod_detalle_venta_seq")
	private int Cod_detalle_venta;

	@ManyToOne
	@JoinColumn(name = "Cod_venta")
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "Cod_producto")
	private Producto producto;

	private int Q_unidades;

	public DetalleVenta() {
		super();

	}

	public int getCod_detalle_venta() {
		return Cod_detalle_venta;
	}

	public void setCod_detalle_venta(int cod_detalle_venta) {
		Cod_detalle_venta = cod_detalle_venta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getQ_unidades() {
		return Q_unidades;
	}

	public void setQ_unidades(int q_unidades) {
		Q_unidades = q_unidades;
	}

}
