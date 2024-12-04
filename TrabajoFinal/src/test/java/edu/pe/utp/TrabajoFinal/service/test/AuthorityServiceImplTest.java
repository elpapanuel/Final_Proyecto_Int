package edu.pe.utp.TrabajoFinal.service.test;

import edu.pe.utp.TrabajoFinal.model.Authority;
import edu.pe.utp.TrabajoFinal.repository.AuthorityRepository;
import edu.pe.utp.TrabajoFinal.service.AuthorityService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.pe.utp.TrabajoFinal.serviceimpl.AuthorityServiceImpl;


@SpringBootTest
public class AuthorityServiceImplTest {

    @Mock
    private AuthorityRepository authorityRepository; 

    @InjectMocks
    private AuthorityServiceImpl authorityServiceImpl; 

    private Authority authority1;
    private Authority authority2;

    @BeforeEach
    void setUp() {

        authority1 = new Authority();
        authority1.setId(1);
        authority1.setAuthority("ROLE_ADMIN");

        authority2 = new Authority();
        authority2.setId(2);
        authority2.setAuthority("ROLE_CUSTOMER");


        when(authorityRepository.findById(1)).thenReturn(Optional.of(authority1));
        when(authorityRepository.findById(2)).thenReturn(Optional.of(authority2));
    }

    @Test
    void testFindByUser() throws Exception {
        // Ejecutar el método a probar
        System.out.println("Iniciando la prueba de búsqueda de Authority por ID.");

        Optional<Authority> foundAuthority1 = authorityServiceImpl.findById(1);
        System.out.println("Resultado para ID 1: " + (foundAuthority1.isPresent() ? foundAuthority1.get().getAuthority() : "No encontrado"));

        Optional<Authority> foundAuthority2 = authorityServiceImpl.findById(2);
        System.out.println("Resultado para ID 2: " + (foundAuthority2.isPresent() ? foundAuthority2.get().getAuthority() : "No encontrado"));

        // Validar resultados
        assertTrue(foundAuthority1.isPresent(), "El authority con ID 1 debería existir.");
        assertEquals("ROLE_ADMIN", foundAuthority1.get().getAuthority(),
                "El authority con ID 1 debe ser ROLE_ADMIN.");

        assertTrue(foundAuthority2.isPresent(), "El authority con ID 2 debería existir.");
        assertEquals("ROLE_CUSTOMER", foundAuthority2.get().getAuthority(),
                "El authority con ID 2 debe ser ROLE_CUSTOMER.");

        System.out.println("Prueba de búsqueda completada correctamente.");
    }
}