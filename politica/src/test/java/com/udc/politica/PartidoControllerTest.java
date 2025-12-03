/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica;

/**
 *
 * @author Admin
 */
import com.udc.politica.controller.PartidoController;
import com.udc.politica.model.PartidoPolitico;
import com.udc.politica.service.PartidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PartidoController.class)
public class PartidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PartidoService servicio;

    @Test
    public void testListarPartidos() throws Exception {
        PartidoPolitico p1 = new PartidoPolitico();
        p1.setNombre("Partido A");
        
        given(servicio.listarTodos()).willReturn(Arrays.asList(p1));

        mockMvc.perform(get("/api/partidos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Partido A"));
    }
}