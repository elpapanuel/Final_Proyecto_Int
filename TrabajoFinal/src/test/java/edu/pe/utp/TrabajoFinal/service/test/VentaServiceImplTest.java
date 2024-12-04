package edu.pe.utp.TrabajoFinal.service.test;

import edu.pe.utp.TrabajoFinal.model.Cliente;
import edu.pe.utp.TrabajoFinal.model.Venta;
import edu.pe.utp.TrabajoFinal.repository.VentaRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.VentaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class VentaServiceImplTest {

    @Autowired
    private VentaServiceImpl ventaService;

    @MockBean
    private VentaRepository ventaRepository;

    @BeforeEach
    public void setUp() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setN_persona("Juan Pérez");

        Venta venta = new Venta();
        venta.setCod_venta(1);
        venta.setD_venta(new Date());
        venta.setCliente(cliente);

        when(ventaRepository.save(any(Venta.class))).thenReturn(venta);
        when(ventaRepository.getMaxCod()).thenReturn(1);
    }

    @Test
    public void testVentaService() throws Exception {
        int maxCod = ventaService.getMaxCod();
        System.out.println("Código máximo de venta: " + maxCod);
        System.out.println("Venta de Prueba realizada con exito");
        assert(maxCod == 1);
    }
}