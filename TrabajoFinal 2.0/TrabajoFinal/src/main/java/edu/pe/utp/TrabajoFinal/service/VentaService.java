package edu.pe.utp.TrabajoFinal.service;


import edu.pe.utp.TrabajoFinal.entity.Venta;


public interface VentaService extends CrudService<Venta, Integer> {
	int getMaxCod() throws Exception;
}
