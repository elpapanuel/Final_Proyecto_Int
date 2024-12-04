package edu.pe.utp.TrabajoFinal.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.pe.utp.TrabajoFinal.model.Proveedor;
import edu.pe.utp.TrabajoFinal.repository.ProveedorRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.ProveedorServiceImpl;

public class ProveedorServiceImplTest {

    @Mock
    private ProveedorRepository proveedorRepository;

    @InjectMocks
    private ProveedorServiceImpl proveedorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() throws Exception {
        System.out.println("Ejecutando test: testFindById");

        Proveedor proveedor = new Proveedor();
        proveedor.setCod_proveedor(1);
        proveedor.setN_proveedor("Proveedor 1");

        when(proveedorRepository.findById(1)).thenReturn(Optional.of(proveedor));

        Optional<Proveedor> result = proveedorService.findById(1);

        assertTrue(result.isPresent(), "El proveedor debería estar presente.");
        assertEquals(1, result.get().getCod_proveedor(), "El ID del proveedor debería ser 1.");
        assertEquals("Proveedor 1", result.get().getN_proveedor(), "El nombre del proveedor debería ser 'Proveedor 1'.");
        verify(proveedorRepository, times(1)).findById(1);

        System.out.println("Proveedor encontrado: " + result.get());
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        System.out.println("Ejecutando test: testFindByIdNotFound");

        when(proveedorRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Proveedor> result = proveedorService.findById(1);

        assertTrue(result.isEmpty(), "El proveedor no debería estar presente.");
        verify(proveedorRepository, times(1)).findById(1);

        System.out.println("Proveedor con ID 1 no encontrado.");
    }

    @Test
    public void testSaveProveedor() throws Exception {
        System.out.println("Ejecutando test: testSaveProveedor");

        Proveedor proveedor = new Proveedor();
        proveedor.setCod_proveedor(1);
        proveedor.setN_proveedor("Proveedor 1");

        when(proveedorRepository.save(proveedor)).thenReturn(proveedor);

        Proveedor result = proveedorService.create(proveedor);

        assertNotNull(result, "El proveedor guardado no debería ser nulo.");
        assertEquals(1, result.getCod_proveedor(), "El ID del proveedor debería ser 1.");
        assertEquals("Proveedor 1", result.getN_proveedor(), "El nombre del proveedor debería ser 'Proveedor 1'.");
        verify(proveedorRepository, times(1)).save(proveedor);

        System.out.println("Proveedor guardado: " + result);
    }

    @Test
    public void testDeleteById() throws Exception {
        System.out.println("Ejecutando test: testDeleteById");

        proveedorService.deleteById(1);

        verify(proveedorRepository, times(1)).deleteById(1);

        System.out.println("Proveedor con ID 1 eliminado.");
    }
}