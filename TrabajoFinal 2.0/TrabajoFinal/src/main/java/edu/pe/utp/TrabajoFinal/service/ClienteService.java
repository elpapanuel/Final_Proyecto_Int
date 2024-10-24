package edu.pe.utp.TrabajoFinal.service;


import edu.pe.utp.TrabajoFinal.entity.Cliente;


public interface ClienteService extends CrudService<Cliente, Integer> {
	void updateClienteByDNI(int DNI,int user_id) throws Exception;
}
