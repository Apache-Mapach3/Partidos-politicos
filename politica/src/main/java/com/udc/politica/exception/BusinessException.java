/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.exception;

/**
 * Excepción personalizada para errores de lógica de negocio.
 * Se lanza cuando se viola una regla de negocio (ej: partido duplicado).
 * 
 * Retorna código HTTP 400 (Bad Request)
 * 
 * @author Jarry
 */
public class BusinessException extends RuntimeException {

    /**
     * Constructor con mensaje personalizado
     * 
     * @param message Mensaje descriptivo del error de negocio
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa
     * 
     * @param message Mensaje descriptivo del error de negocio
     * @param cause Causa raíz de la excepción
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}