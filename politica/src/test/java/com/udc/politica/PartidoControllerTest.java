/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica;

import com.udc.politica.controller.PartidoController;
import com.udc.politica.dto.PartidoPoliticoDTO;
import com.udc.politica.mapper.PartidoPoliticoMapper;
import com.udc.politica.model.PartidoPolitico;
import com.udc.politica.service.PartidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PartidoController.class)
public class PartidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PartidoService servicio;

    @MockBean
    private PartidoPoliticoMapper mapper;

    private PartidoPolitico partidoEntidad;
    private PartidoPoliticoDTO partidoDTO;

    @BeforeEach
    void setUp() {
        // Configuramos los datos manualmente (sin builder)
        partidoEntidad = new PartidoPolitico();
        partidoEntidad.setId(1L);
        partidoEntidad.setNombre("Partido A");
        partidoEntidad.setPais("Colombia");

        partidoDTO = new PartidoPoliticoDTO();
        partidoDTO.setId(1L);
        partidoDTO.setNombre("Partido A");
        partidoDTO.setPais("Colombia");
    }

    @Test
    public void testListarPartidos() throws Exception {
        // 1. Simulamos que el SERVICIO devuelve Entidades (Correcto)
        given(servicio.listarTodos()).willReturn(Arrays.asList(partidoEntidad));
        
        // 2. Simulamos que el MAPPER convierte Entidad -> DTO
        given(mapper.toDTO(any(PartidoPolitico.class))).willReturn(partidoDTO);

        mockMvc.perform(get("/api/partidos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Partido A"));
    }

    @Test
    public void testObtenerPartido() throws Exception {
        given(servicio.obtenerPorId(1L)).willReturn(Optional.of(partidoEntidad));
        given(mapper.toDTO(any(PartidoPolitico.class))).willReturn(partidoDTO);

        mockMvc.perform(get("/api/partidos/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Partido A"));
    }

    @Test
    public void testCrearPartido() throws Exception {
        given(mapper.toEntity(any(PartidoPoliticoDTO.class))).willReturn(partidoEntidad);
        given(servicio.guardarPartido(any(PartidoPolitico.class))).willReturn(partidoEntidad);
        given(mapper.toDTO(any(PartidoPolitico.class))).willReturn(partidoDTO);

        String jsonBody = "{\"nombre\": \"Partido A\", \"pais\": \"Colombia\"}";

        mockMvc.perform(post("/api/partidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Partido A"));
    }

    @Test
    public void testEliminarPartido() throws Exception {
        doNothing().when(servicio).eliminarPartido(1L);

        mockMvc.perform(delete("/api/partidos/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}