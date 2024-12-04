package edu.pe.utp.TrabajoFinal.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CarritoCompras")
@SequenceGenerator(name = "CarritoCompras_Cod_carrito_compra_seq", initialValue = 100, allocationSize = 1)
public class CarritoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CarritoCompras_Cod_carrito_compra_seq")
	private int Cod_carrito_compra;
	
	@ManyToOne  ()
    @JoinColumn(name = "Num_DNI")
	private Cliente cliente;
    @ManyToOne ()
    @JoinColumn(name = "Cod_producto")
    private Producto producto;
	
    @Column(name = "Q_unidades", nullable = false)
   private int Q_unidades;

	public CarritoCompra() {
		super();
		
	}

	public int getCod_carrito_compra() {
		return Cod_carrito_compra;
	}

	public void setCod_carrito_compra(int cod_carrito_compra) {
		Cod_carrito_compra = cod_carrito_compra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
