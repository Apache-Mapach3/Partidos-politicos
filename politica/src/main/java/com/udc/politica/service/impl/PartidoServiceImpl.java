/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.service.impl;

/**
 *
 * @author Admin
 */
import com.udc.politica.model.PartidoPolitico;
import com.udc.politica.repository.PartidoPoliticoRepository;
import com.udc.politica.service.PartidoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PartidoServiceImpl implements PartidoService {

    private final PartidoPoliticoRepository repositorio;

    // PRINCIPIO SOLID: Inyección por constructor (No usar @Autowired en campos)
    public PartidoServiceImpl(PartidoPoliticoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public PartidoPolitico guardarPartido(PartidoPolitico partido) {
        return repositorio.save(partido);
    }

    @Override
    public List<PartidoPolitico> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Optional<PartidoPolitico> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminarPartido(Long id) {
        repositorio.deleteById(id);
    }
}
