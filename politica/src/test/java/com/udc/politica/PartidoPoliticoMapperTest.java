/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica;

import com.udc.politica.dto.PartidoPoliticoDTO;
import com.udc.politica.mapper.PartidoPoliticoMapper;
import com.udc.politica.model.PartidoPolitico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PartidoPoliticoMapperTest {

    private final PartidoPoliticoMapper mapper = new PartidoPoliticoMapper();

    @Test
    public void testToDTO() {
        // Datos de entrada (Entidad)
        PartidoPolitico entidad = new PartidoPolitico();
        entidad.setId(1L);
        entidad.setNombre("Partido Test");
        entidad.setPais("Colombia");
        entidad.setNumPresidentes(2);

        // Ejecutar
        PartidoPoliticoDTO dto = mapper.toDTO(entidad);

        // Verificar
        assertNotNull(dto);
        assertEquals(entidad.getId(), dto.getId());
        assertEquals(entidad.getNombre(), dto.getNombre());
        assertEquals(entidad.getPais(), dto.getPais());
        assertEquals(entidad.getNumPresidentes(), dto.getNumPresidentes());
    }

    @Test
    public void testToEntity() {
        // Datos de entrada (DTO)
        PartidoPoliticoDTO dto = new PartidoPoliticoDTO();
        dto.setId(1L);
        dto.setNombre("Partido DTO");
        dto.setPais("Peru");
        dto.setNumCongresistas(10);

        // Ejecutar
        PartidoPolitico entidad = mapper.toEntity(dto);

        // Verificar
        assertNotNull(entidad);
        assertEquals(dto.getId(), entidad.getId());
        assertEquals(dto.getNombre(), entidad.getNombre());
        assertEquals(dto.getPais(), entidad.getPais());
        assertEquals(dto.getNumCongresistas(), entidad.getNumCongresistas());
    }
    
    @Test
    public void testNullInputs() {
        assertNull(mapper.toDTO(null));
        assertNull(mapper.toEntity(null));
    }
}