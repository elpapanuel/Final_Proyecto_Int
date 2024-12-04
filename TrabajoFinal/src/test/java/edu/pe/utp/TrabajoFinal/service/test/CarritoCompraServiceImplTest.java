package edu.pe.utp.TrabajoFinal.service.test;

import edu.pe.utp.TrabajoFinal.model.CarritoCompra;
import edu.pe.utp.TrabajoFinal.repository.CarritoCompraRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.CarritoCompraServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarritoCompraServiceImplTest {

    @Mock
    private CarritoCompraRepository carritoCompraRepository;

    @InjectMocks
    private CarritoCompraServiceImpl carritoCompraService;

    @BeforeEach
    void setUp() throws Exception {
        doNothing().when(carritoCompraRepository).deleteByIdCustomer(anyInt());
    }

    @Test
    void testDeleteByIdCustomer() throws Exception {
        Integer id = 1;

        carritoCompraService.deleteByIdCustomer(id);

        verify(carritoCompraRepository, times(1)).deleteByIdCustomer(id);

        System.out.println("Prueba exitosa: deleteByIdCustomer ejecutado correctamente.");
    }

    @Test
    void testGetJpaRepository() {
        var result = carritoCompraService.getJpaRepository();

        assertNotNull(result, "El repositorio no debe ser null.");
        assertEquals(carritoCompraRepository, result, "El repositorio devuelto debe coincidir con el mock.");

        System.out.println("Prueba exitosa: getJpaRepository devuelve el repositorio correcto.");
    }
}