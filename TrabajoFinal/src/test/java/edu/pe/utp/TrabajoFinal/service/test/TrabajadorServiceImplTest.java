package edu.pe.utp.TrabajoFinal.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.pe.utp.TrabajoFinal.model.Trabajador;
import edu.pe.utp.TrabajoFinal.repository.TrabajadorRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.TrabajadorServiceImpl;

public class TrabajadorServiceImplTest {

    @Mock
    private TrabajadorRepository trabajadorRepository;

    @InjectMocks
    private TrabajadorServiceImpl trabajadorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() throws Exception {
        System.out.println("Ejecutando test: testFindById");

        Trabajador trabajador = new Trabajador();
        trabajador.setNum_DNI(1);
        trabajador.setN_persona("Trabajador 1");

        when(trabajadorRepository.findById(1)).thenReturn(Optional.of(trabajador));

        Optional<Trabajador> result = trabajadorService.findById(1);

        assertTrue(result.isPresent(), "El trabajador debería estar presente.");
        assertEquals(1, result.get().getNum_DNI(), "El DNI del trabajador debería ser 1.");
        assertEquals("Trabajador 1", result.get().getN_persona(), "El nombre del trabajador debería ser 'Trabajador 1'.");
        verify(trabajadorRepository, times(1)).findById(1);

        System.out.println("Trabajador encontrado: " + result.get());
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        System.out.println("Ejecutando test: testFindByIdNotFound");

        when(trabajadorRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Trabajador> result = trabajadorService.findById(1);

        assertTrue(result.isEmpty(), "El trabajador no debería estar presente.");
        verify(trabajadorRepository, times(1)).findById(1);

        System.out.println("Trabajador con ID 1 no encontrado.");
    }

    @Test
    public void testSaveTrabajador() throws Exception {
        System.out.println("Ejecutando test: testSaveTrabajador");

        Trabajador trabajador = new Trabajador();
        trabajador.setNum_DNI(1);
        trabajador.setN_persona("Trabajador 1");

        when(trabajadorRepository.save(trabajador)).thenReturn(trabajador);

        Trabajador result = trabajadorService.create(trabajador);

        assertNotNull(result, "El trabajador guardado no debería ser nulo.");
        assertEquals(1, result.getNum_DNI(), "El ID del trabajador debería ser 1.");
        assertEquals("Trabajador 1", result.getN_persona(), "El nombre del trabajador debería ser 'Trabajador 1'.");
        verify(trabajadorRepository, times(1)).save(trabajador);

        System.out.println("Trabajador guardado: " + result);
    }

    @Test
    public void testDeleteById() throws Exception {
        System.out.println("Ejecutando test: testDeleteById");

        trabajadorService.deleteById(1);

        verify(trabajadorRepository, times(1)).deleteById(1);

        System.out.println("Trabajador con ID 1 eliminado.");
    }
}