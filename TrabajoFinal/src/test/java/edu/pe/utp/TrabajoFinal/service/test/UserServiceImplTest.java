package edu.pe.utp.TrabajoFinal.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.pe.utp.TrabajoFinal.model.User;
import edu.pe.utp.TrabajoFinal.repository.UserRepository;
import edu.pe.utp.TrabajoFinal.serviceimpl.UserServiceImpl;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByUsername() {
        System.out.println("Ejecutando test: testFindByUsername");

        User user = new User();
        user.setId(1);
        user.setUsername("testUser");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByUsername("testUser");

        assertTrue(result.isPresent(), "El usuario debería estar presente.");
        assertEquals("testUser", result.get().getUsername(), "El username debería ser 'testUser'.");
        verify(userRepository, times(1)).findByUsername("testUser");

        System.out.println("Usuario encontrado: " + result.get());
    }

    @Test
    public void testFindByUsernameNotFound() {
        System.out.println("Ejecutando test: testFindByUsernameNotFound");

        when(userRepository.findByUsername("unknownUser")).thenReturn(Optional.empty());

        Optional<User> result = userService.findByUsername("unknownUser");

        assertTrue(result.isEmpty(), "El usuario no debería estar presente.");
        verify(userRepository, times(1)).findByUsername("unknownUser");

        System.out.println("Usuario con username 'unknownUser' no encontrado.");
    }

    @Test
    public void testGetMaxIdUser() throws Exception {
        System.out.println("Ejecutando test: testGetMaxIdUser");

        when(userRepository.getMaxIdUser()).thenReturn(100);

        int maxId = userService.getMaxIdUser();

        assertEquals(100, maxId, "El máximo ID debería ser 100.");
        verify(userRepository, times(1)).getMaxIdUser();

        System.out.println("Máximo ID de usuario: " + maxId);
    }

    @Test
    public void testFindById() throws Exception {
        System.out.println("Ejecutando test: testFindById");

        User user = new User();
        user.setId(1);
        user.setUsername("testUser");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(1);

        assertTrue(result.isPresent(), "El usuario debería estar presente.");
        assertEquals(1, result.get().getId(), "El ID debería ser 1.");
        verify(userRepository, times(1)).findById(1);

        System.out.println("Usuario encontrado por ID: " + result.get());
    }

    @Test
    public void testInsertUser() throws Exception {
        System.out.println("Ejecutando test: testInsertUser");

        doNothing().when(userRepository).insert(1, "password123", "testUser");

        userService.insert(1, "password123", "testUser");

        verify(userRepository, times(1)).insert(1, "password123", "testUser");

        System.out.println("Usuario insertado con ID: 1, username: 'testUser'.");
    }
}