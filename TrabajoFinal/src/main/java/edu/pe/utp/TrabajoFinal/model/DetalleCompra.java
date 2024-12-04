package edu.pe.utp.TrabajoFinal.model;

import javax.persistence.CascadeType;
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
@Table(name="DetalleCompras")
@SequenceGenerator(name = "DetalleCompras_Cod_detalle_compra_seq", initialValue = 100, allocationSize = 1)
public class DetalleCompra  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleCompras_Cod_detalle_compra_seq")
	private int Cod_detalle_compra;
	
	@ManyToOne 
    @JoinColumn(name = "Cod_compra")
	private Compra compra;

    @ManyToOne 
    @JoinColumn(name = "Cod_proveedor")
    private Proveedor proveedor;
	
    @ManyToOne 
    @JoinColumn(name = "Cod_producto")
    private Producto producto;
    
   private int Q_unidades;
    
    
    public DetalleCompra() {
		super();
	}


	


	public int getCod_detalle_compra() {
		return Cod_detalle_compra;
	}





	public void setCod_detalle_compra(int cod_detalle_compra) {
		Cod_detalle_compra = cod_detalle_compra;
	}





	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
