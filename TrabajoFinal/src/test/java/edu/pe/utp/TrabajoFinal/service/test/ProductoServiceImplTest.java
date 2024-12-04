package edu.pe.utp.TrabajoFinal.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.pe.utp.TrabajoFinal.model.Producto;
import edu.pe.utp.TrabajoFinal.repository.ProductoRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.ProductoServiceImpl;

public class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository; 

    @InjectMocks
    private ProductoServiceImpl productoService; 

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testGetListEightProducts() throws Exception {
        System.out.println("Ejecutando test: testGetListEightProducts");


        Producto producto1 = new Producto();
        producto1.setCod_producto(1);
        producto1.setN_producto("Producto 1");

        Producto producto2 = new Producto();
        producto2.setCod_producto(2);
        producto2.setN_producto("Producto 2");

        List<Producto> mockProducts = Arrays.asList(producto1, producto2);


        when(productoRepository.getListEightProducts()).thenReturn(mockProducts);


        List<Producto> result = productoService.getListEightProducts();


        assertNotNull(result, "La lista de productos no debería ser nula.");
        assertEquals(2, result.size(), "La lista debería contener 2 productos.");
        assertEquals("Producto 1", result.get(0).getN_producto(), "El primer producto debería ser 'Producto 1'.");
        assertEquals("Producto 2", result.get(1).getN_producto(), "El segundo producto debería ser 'Producto 2'.");
        verify(productoRepository, times(1)).getListEightProducts();

        System.out.println("Productos obtenidos: " + result);
    }

    @Test
    public void testGetListEightProductsEmpty() throws Exception {
        System.out.println("Ejecutando test: testGetListEightProductsEmpty");


        when(productoRepository.getListEightProducts()).thenReturn(Arrays.asList());


        List<Producto> result = productoService.getListEightProducts();


        assertNotNull(result, "La lista de productos no debería ser nula.");
        assertTrue(result.isEmpty(), "La lista debería estar vacía.");
        verify(productoRepository, times(1)).getListEightProducts();

        System.out.println("No se obtuvieron productos.");
    }

    @Test
    public void testFindById() throws Exception {
        System.out.println("Ejecutando test: testFindById");

        Producto producto = new Producto();
        producto.setCod_producto(1);
        producto.setN_producto("Producto 1");


        when(productoRepository.findById(1)).thenReturn(java.util.Optional.of(producto));


        Optional<Producto> result = productoService.findById(1);

  
        assertTrue(result.isPresent(), "El producto debería estar presente.");
        assertEquals(1, result.get().getCod_producto(), "El ID del producto debería ser 1.");
        assertEquals("Producto 1", result.get().getN_producto(), "El nombre del producto debería ser 'Producto 1'.");
        verify(productoRepository, times(1)).findById(1);

        System.out.println("Producto encontrado: " + result.get());
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        System.out.println("Ejecutando test: testFindByIdNotFound");

     
        when(productoRepository.findById(1)).thenReturn(Optional.empty());

      
        Optional<Producto> result = productoService.findById(1);

        
        assertTrue(result.isEmpty(), "El producto no debería estar presente.");
        verify(productoRepository, times(1)).findById(1);

        System.out.println("Producto con ID 1 no encontrado.");
    }
}