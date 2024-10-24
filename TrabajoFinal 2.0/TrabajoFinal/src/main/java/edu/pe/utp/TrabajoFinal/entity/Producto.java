package edu.pe.utp.TrabajoFinal.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Productos")
@SequenceGenerator(name = "Productos_Cod_producto_seq", initialValue = 100, allocationSize = 1)
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Productos_Cod_producto_seq")
	private int Cod_producto;

	@NotEmpty(message = "Debe ingresar el nombre del producto")
	@Column(name = "N_producto", nullable = false, length = 150)
	private String N_producto;

	@Column(name = "Q_producto", nullable = false)
	private int Q_producto;

	@Column(name = "Monto_unitario", nullable = false)
	private double Monto_unitario;

	@Column(name = "F_estado", nullable = false)
	private boolean F_estado;

	@Column(name = "image", nullable = true)
	private String image;

	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleCompra> DetalleCompras;

	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleVenta> DetalleVentas;

	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CarritoCompra> CarritoCompras;

	public Producto() {
		super();
		DetalleCompras= new ArrayList<DetalleCompra>();
		DetalleVentas= new ArrayList<DetalleVenta>();
		CarritoCompras= new ArrayList<CarritoCompra>();
	}

	public List<DetalleCompra> getDetalleCompras() {
		return DetalleCompras;
	}

	public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
		DetalleCompras = detalleCompras;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return DetalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		DetalleVentas = detalleVentas;
	}

	public List<CarritoCompra> getCarritoCompras() {
		return CarritoCompras;
	}

	public void setCarritoCompras(List<CarritoCompra> carritoCompras) {
		CarritoCompras = carritoCompras;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCod_producto() {
		return Cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		Cod_producto = cod_producto;
	}

	public String getN_producto() {
		return N_producto;
	}

	public void setN_producto(String n_producto) {
		N_producto = n_producto;
	}

	public int getQ_producto() {
		return Q_producto;
	}

	public void setQ_producto(int q_producto) {
		Q_producto = q_producto;
	}

	public double getMonto_unitario() {
		return Monto_unitario;
	}

	public void setMonto_unitario(double monto_unitario) {
		Monto_unitario = monto_unitario;
	}

	public boolean isF_estado() {
		return F_estado;
	}

	public void setF_estado(boolean f_estado) {
		F_estado = f_estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CarritoCompras, Cod_producto, DetalleCompras, DetalleVentas, F_estado, Monto_unitario,
				N_producto, Q_producto, image);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(CarritoCompras, other.CarritoCompras) && Cod_producto == other.Cod_producto
				&& Objects.equals(DetalleCompras, other.DetalleCompras)
				&& Objects.equals(DetalleVentas, other.DetalleVentas) && F_estado == other.F_estado
				&& Double.doubleToLongBits(Monto_unitario) == Double.doubleToLongBits(other.Monto_unitario)
				&& Objects.equals(N_producto, other.N_producto) && Q_producto == other.Q_producto
				&& Objects.equals(image, other.image);
	}

}
