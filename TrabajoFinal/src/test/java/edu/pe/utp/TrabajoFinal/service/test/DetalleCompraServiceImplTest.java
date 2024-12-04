package edu.pe.utp.TrabajoFinal.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.pe.utp.TrabajoFinal.model.DetalleCompra;
import edu.pe.utp.TrabajoFinal.repository.DetalleCompraRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.DetalleCompraServiceImpl;

public class DetalleCompraServiceImplTest {

    @Mock
    private DetalleCompraRepository detalleCompraRepository;

    @InjectMocks
    private DetalleCompraServiceImpl detalleCompraService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() throws Exception {
        System.out.println("Ejecutando test: testFindById");

        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCod_detalle_compra(1);

        when(detalleCompraRepository.findById(1)).thenReturn(Optional.of(detalleCompra));

        Optional<DetalleCompra> result = detalleCompraService.findById(1);

        assertTrue(result.isPresent(), "El detalle de compra debería estar presente.");
        assertEquals(1, result.get().getCod_detalle_compra(), "El ID del detalle de compra debería ser 1.");
        verify(detalleCompraRepository, times(1)).findById(1);

        System.out.println("DetalleCompra encontrado: " + result.get());
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        System.out.println("Ejecutando test: testFindByIdNotFound");

        when(detalleCompraRepository.findById(1)).thenReturn(Optional.empty());

        Optional<DetalleCompra> result = detalleCompraService.findById(1);

        assertTrue(result.isEmpty(), "El detalle de compra no debería estar presente.");
        verify(detalleCompraRepository, times(1)).findById(1);

        System.out.println("DetalleCompra con ID 1 no encontrado.");
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("Ejecutando test: testCreate");

        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCod_detalle_compra(1);

        when(detalleCompraRepository.save(detalleCompra)).thenReturn(detalleCompra);

        DetalleCompra result = detalleCompraService.create(detalleCompra);

        assertNotNull(result, "El detalle de compra creado no debería ser nulo.");
        assertEquals(1, result.getCod_detalle_compra(), "El ID del detalle de compra debería ser 1.");
        verify(detalleCompraRepository, times(1)).save(detalleCompra);

        System.out.println("DetalleCompra creado exitosamente: " + result);
    }

    @Test
    public void testDeleteById() throws Exception {
        System.out.println("Ejecutando test: testDeleteById");

        detalleCompraService.deleteById(1);

        verify(detalleCompraRepository, times(1)).deleteById(1);

        System.out.println("DetalleCompra con ID 1 eliminado exitosamente.");
    }
}