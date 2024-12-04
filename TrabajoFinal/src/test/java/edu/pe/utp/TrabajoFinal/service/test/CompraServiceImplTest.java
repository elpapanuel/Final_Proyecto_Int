package edu.pe.utp.TrabajoFinal.service.test;

import edu.pe.utp.TrabajoFinal.model.Compra;
import edu.pe.utp.TrabajoFinal.repository.CompraRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.CompraServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompraServiceImplTest {

    @Mock
    private CompraRepository compraRepository; 

    @InjectMocks
    private CompraServiceImpl compraService;

    @Test
    void testGetJpaRepository() {

        var result = compraService.getJpaRepository();

        assertNotNull(result, "El repositorio no debe ser null.");
        assertEquals(compraRepository, result, "El repositorio devuelto debe coincidir con el mock.");


        System.out.println("Prueba exitosa: getJpaRepository devuelve el repositorio correcto.");
    }
}