package edu.pe.utp.TrabajoFinal.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.pe.utp.TrabajoFinal.model.DetalleVenta;
import edu.pe.utp.TrabajoFinal.repository.DetalleVentaRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.DetalleVentaServiceImpl;

public class DetalleVentaServiceImplTest {

    @Mock
    private DetalleVentaRepository detalleVentaRepository;

    @InjectMocks
    private DetalleVentaServiceImpl detalleVentaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() throws Exception {
        System.out.println("Ejecutando test: testFindById");

        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setCod_detalle_venta(1);

        when(detalleVentaRepository.findById(1)).thenReturn(Optional.of(detalleVenta));

        Optional<DetalleVenta> result = detalleVentaService.findById(1);

        assertTrue(result.isPresent(), "El detalle de venta debería estar presente.");
        assertEquals(1, result.get().getCod_detalle_venta(), "El ID del detalle de venta debería ser 1.");
        verify(detalleVentaRepository, times(1)).findById(1);

        System.out.println("DetalleVenta encontrado: " + result.get());
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        System.out.println("Ejecutando test: testFindByIdNotFound");

        when(detalleVentaRepository.findById(1)).thenReturn(Optional.empty());

        Optional<DetalleVenta> result = detalleVentaService.findById(1);

        assertTrue(result.isEmpty(), "El detalle de venta no debería estar presente.");
        verify(detalleVentaRepository, times(1)).findById(1);

        System.out.println("DetalleVenta con ID 1 no encontrado.");
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("Ejecutando test: testCreate");

        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setCod_detalle_venta(1);

        when(detalleVentaRepository.save(detalleVenta)).thenReturn(detalleVenta);

        DetalleVenta result = detalleVentaService.create(detalleVenta);

        assertNotNull(result, "El detalle de venta creado no debería ser nulo.");
        assertEquals(1, result.getCod_detalle_venta(), "El ID del detalle de venta debería ser 1.");
        verify(detalleVentaRepository, times(1)).save(detalleVenta);

        System.out.println("DetalleVenta creado exitosamente: " + result);
    }

    @Test
    public void testDeleteById() throws Exception {
        System.out.println("Ejecutando test: testDeleteById");

        detalleVentaService.deleteById(1);

        verify(detalleVentaRepository, times(1)).deleteById(1);

        System.out.println("DetalleVenta con ID 1 eliminado exitosamente.");
    }
}