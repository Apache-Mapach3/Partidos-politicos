/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.service;

/**
 *
 * @author Admin
 */
import com.udc.politica.model.PartidoPolitico;
import java.util.List;
import java.util.Optional;

public interface PartidoService {
    PartidoPolitico guardarPartido(PartidoPolitico partido);
    List<PartidoPolitico> listarTodos();
    Optional<PartidoPolitico> obtenerPorId(Long id);
    void eliminarPartido(Long id);
}
