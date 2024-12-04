package edu.pe.utp.TrabajoFinal.service;


import java.util.List;

import edu.pe.utp.TrabajoFinal.model.Producto;


public interface ProductoService extends CrudService<Producto, Integer> {
	List<Producto> getListEightProducts() throws Exception;
}
