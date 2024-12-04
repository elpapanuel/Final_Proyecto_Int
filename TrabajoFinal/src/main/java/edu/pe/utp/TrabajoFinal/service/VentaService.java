package edu.pe.utp.TrabajoFinal.service;


import edu.pe.utp.TrabajoFinal.model.Venta;


public interface VentaService extends CrudService<Venta, Integer> {
	int getMaxCod() throws Exception;
}
