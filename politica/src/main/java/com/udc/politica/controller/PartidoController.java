/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.controller;

import com.udc.politica.dto.PartidoPoliticoDTO;
import com.udc.politica.mapper.PartidoPoliticoMapper;
import com.udc.politica.model.PartidoPolitico;
import com.udc.politica.service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = "*")
public class PartidoController {

    private final PartidoService servicio;
    private final PartidoPoliticoMapper mapper;

    public PartidoController(PartidoService servicio, PartidoPoliticoMapper mapper) {
        this.servicio = servicio;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PartidoPoliticoDTO> crear(@RequestBody PartidoPoliticoDTO dto) {
        // 1. Convertir DTO a Entidad
        PartidoPolitico entidad = mapper.toEntity(dto);
        // 2. Guardar Entidad usando el servicio
        PartidoPolitico guardado = servicio.guardarPartido(entidad);
        // 3. Convertir Entidad guardada a DTO y devolver
        return new ResponseEntity<>(mapper.toDTO(guardado), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PartidoPoliticoDTO>> listar() {
        List<PartidoPolitico> listaEntidades = servicio.listarTodos();
        // Convertir lista de Entidades a lista de DTOs
        List<PartidoPoliticoDTO> listaDTOs = listaEntidades.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoPoliticoDTO> obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(entidad -> ResponseEntity.ok(mapper.toDTO(entidad)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminarPartido(id);
        return ResponseEntity.noContent().build();
    }
}