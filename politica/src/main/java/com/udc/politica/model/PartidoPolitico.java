/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.model;
import jakarta.persistence.*;
import lombok.Data; 

@Data 
@Entity
@Table(name = "partidos_politicos")
public class PartidoPolitico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;
    private String eslogan;
    private String pais;

    // Roles Jerárquicos
    private String presidente;
    private String secretario;
    private String tesorero;

    // Métricas
    private Integer numPresidentes;
    private Integer numGobernadores;
    private Integer numAlcaldes;
    private Integer numConcejales;
    private Integer numCongresistas;
}
