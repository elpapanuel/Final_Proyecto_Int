package edu.pe.utp.TrabajoFinal.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pe.utp.TrabajoFinal.entity.DetalleVenta;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {

}
