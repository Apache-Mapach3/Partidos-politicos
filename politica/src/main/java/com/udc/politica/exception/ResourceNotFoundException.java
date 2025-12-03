/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.exception;

/**
 * Excepción personalizada para cuando no se encuentra un recurso.
 * Se lanza cuando se busca una entidad por ID y no existe en la base de datos.
 * 
 * Retorna código HTTP 404 (Not Found)
 * 
 * @author Jarry
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor con mensaje personalizado
     * 
     * @param message Mensaje descriptivo del error
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa
     * 
     * @param message Mensaje descriptivo del error
     * @param cause Causa raíz de la excepción
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}