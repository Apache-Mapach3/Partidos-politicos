/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica;

/**
 *
 * @author Admin
 */
import com.udc.politica.model.PartidoPolitico;
import com.udc.politica.repository.PartidoPoliticoRepository;
import com.udc.politica.service.impl.PartidoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PartidoServiceTest {

    @Mock
    private PartidoPoliticoRepository repositorio;

    @InjectMocks
    private PartidoServiceImpl servicio;

    private PartidoPolitico partido;

    @BeforeEach
    void setUp() {
        partido = new PartidoPolitico();
        partido.setNombre("Partido Test");
    }

    @Test
    void testGuardarPartido() {
        when(repositorio.save(any(PartidoPolitico.class))).thenReturn(partido);
        PartidoPolitico resultado = servicio.guardarPartido(partido);
        assertNotNull(resultado);
        assertEquals("Partido Test", resultado.getNombre());
    }
}