/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.mapper;

/**
 * Mapper para convertir entre Entidad (PartidoPolitico) y DTO (PartidoPoliticoDTO).
 * Implementa el patrón Mapper para mantener separadas las capas de dominio y presentación.
 * 
 * Principios aplicados:
 * - Single Responsibility: Solo se encarga de la conversión entre capas
 * - Open/Closed: Extensible sin modificar código existente
 * 
 * @author Jarry
 */
import com.udc.politica.dto.PartidoPoliticoDTO;
import com.udc.politica.model.PartidoPolitico;
import org.springframework.stereotype.Component;

@Component
public class PartidoPoliticoMapper {

    // Convertir de Entidad a DTO (Manual)
    public PartidoPoliticoDTO toDTO(PartidoPolitico entidad) {
        if (entidad == null) return null;

        PartidoPoliticoDTO dto = new PartidoPoliticoDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setEslogan(entidad.getEslogan());
        dto.setPais(entidad.getPais());
        dto.setPresidente(entidad.getPresidente());
        dto.setSecretario(entidad.getSecretario());
        dto.setTesorero(entidad.getTesorero());
        dto.setNumPresidentes(entidad.getNumPresidentes());
        dto.setNumGobernadores(entidad.getNumGobernadores());
        dto.setNumAlcaldes(entidad.getNumAlcaldes());
        dto.setNumConcejales(entidad.getNumConcejales());
        dto.setNumCongresistas(entidad.getNumCongresistas());
        return dto;
    }

    // Convertir de DTO a Entidad (Manual)
    public PartidoPolitico toEntity(PartidoPoliticoDTO dto) {
        if (dto == null) return null;

        PartidoPolitico entidad = new PartidoPolitico();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setEslogan(dto.getEslogan());
        entidad.setPais(dto.getPais());
        entidad.setPresidente(dto.getPresidente());
        entidad.setSecretario(dto.getSecretario());
        entidad.setTesorero(dto.getTesorero());
        entidad.setNumPresidentes(dto.getNumPresidentes());
        entidad.setNumGobernadores(dto.getNumGobernadores());
        entidad.setNumAlcaldes(dto.getNumAlcaldes());
        entidad.setNumConcejales(dto.getNumConcejales());
        entidad.setNumCongresistas(dto.getNumCongresistas());
        return entidad;
    }
}