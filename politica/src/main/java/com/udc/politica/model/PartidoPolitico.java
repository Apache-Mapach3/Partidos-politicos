/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udc.politica.model;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "partidos_politicos", 
       uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class PartidoPolitico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(length = 200)
    private String eslogan;

    @Column(nullable = false, length = 50)
    private String pais;

    @Column(length = 100)
    private String presidente;

    @Column(length = 100)
    private String secretario;

    @Column(length = 100)
    private String tesorero;

    @Column(name = "num_presidentes")
    private Integer numPresidentes;

    @Column(name = "num_gobernadores")
    private Integer numGobernadores;

    @Column(name = "num_alcaldes")
    private Integer numAlcaldes;

    @Column(name = "num_concejales")
    private Integer numConcejales;

    @Column(name = "num_congresistas")
    private Integer numCongresistas;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    // CONSTRUCTORES
    public PartidoPolitico() {}

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEslogan() { return eslogan; }
    public void setEslogan(String eslogan) { this.eslogan = eslogan; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getPresidente() { return presidente; }
    public void setPresidente(String presidente) { this.presidente = presidente; }

    public String getSecretario() { return secretario; }
    public void setSecretario(String secretario) { this.secretario = secretario; }

    public String getTesorero() { return tesorero; }
    public void setTesorero(String tesorero) { this.tesorero = tesorero; }

    public Integer getNumPresidentes() { return numPresidentes; }
    public void setNumPresidentes(Integer numPresidentes) { this.numPresidentes = numPresidentes; }

    public Integer getNumGobernadores() { return numGobernadores; }
    public void setNumGobernadores(Integer numGobernadores) { this.numGobernadores = numGobernadores; }

    public Integer getNumAlcaldes() { return numAlcaldes; }
    public void setNumAlcaldes(Integer numAlcaldes) { this.numAlcaldes = numAlcaldes; }

    public Integer getNumConcejales() { return numConcejales; }
    public void setNumConcejales(Integer numConcejales) { this.numConcejales = numConcejales; }

    public Integer getNumCongresistas() { return numCongresistas; }
    public void setNumCongresistas(Integer numCongresistas) { this.numCongresistas = numCongresistas; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    @Transient
    public Integer getTotalRepresentantes() {
        int total = 0;
        if (numPresidentes != null) total += numPresidentes;
        if (numGobernadores != null) total += numGobernadores;
        if (numAlcaldes != null) total += numAlcaldes;
        if (numConcejales != null) total += numConcejales;
        if (numCongresistas != null) total += numCongresistas;
        return total;
    }

    @PrePersist
    protected void onCreate() {
        if (numPresidentes == null) numPresidentes = 0;
        if (numGobernadores == null) numGobernadores = 0;
        if (numAlcaldes == null) numAlcaldes = 0;
        if (numConcejales == null) numConcejales = 0;
        if (numCongresistas == null) numCongresistas = 0;
    }
}