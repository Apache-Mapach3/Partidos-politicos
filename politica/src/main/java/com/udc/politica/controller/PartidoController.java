/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.controller;

/**
 *
 * @author Admin
 */
import com.udc.politica.model.PartidoPolitico;
import com.udc.politica.service.PartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = "*")
public class PartidoController {

    private final PartidoService servicio;

    public PartidoController(PartidoService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<PartidoPolitico> crear(@RequestBody PartidoPolitico partido) {
        return new ResponseEntity<>(servicio.guardarPartido(partido), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PartidoPolitico>> listar() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoPolitico> obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminarPartido(id);
        return ResponseEntity.noContent().build();
    }
}