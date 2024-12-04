package edu.pe.utp.TrabajoFinal.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pe.utp.TrabajoFinal.model.Compra;
import edu.pe.utp.TrabajoFinal.model.Trabajador;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
