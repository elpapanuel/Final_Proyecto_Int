package edu.pe.utp.TrabajoFinal.service.test;

import edu.pe.utp.TrabajoFinal.model.Cliente;
import edu.pe.utp.TrabajoFinal.repository.ClienteRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.ClienteServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() throws Exception {
        doNothing().when(clienteRepository).updateClienteByDNI(anyInt(), anyInt());
    }

    @Test
    void testGetJpaRepository() {
        var result = clienteService.getJpaRepository();

        assertNotNull(result, "El repositorio no debe ser null.");
        assertEquals(clienteRepository, result, "El repositorio devuelto debe coincidir con el mock.");

        System.out.println("Prueba exitosa: getJpaRepository devuelve el repositorio correcto.");
    }

    @Test
    void testUpdateClienteByDNI() throws Exception {
        int dni = 12345678;
        int userId = 1;

        clienteService.updateClienteByDNI(dni, userId);

        verify(clienteRepository, times(1)).updateClienteByDNI(dni, userId);

        System.out.println("Prueba exitosa: updateClienteByDNI ejecutado correctamente.");
    }
}