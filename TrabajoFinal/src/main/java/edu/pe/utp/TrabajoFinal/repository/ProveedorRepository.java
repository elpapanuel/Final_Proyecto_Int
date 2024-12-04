package edu.pe.utp.TrabajoFinal.repository;

import org.springframework.stereotype.Repository;

import edu.pe.utp.TrabajoFinal.model.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
