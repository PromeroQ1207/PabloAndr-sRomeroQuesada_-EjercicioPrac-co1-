package com.EjercicioPractico1.Domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author pablo
 */
@Data
@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    private String nombre;
    private String identificacion;
    private String nivel_cursando;
    private int edad;
    private double altura;
    private double peso;
    private boolean activo;
    
    public Estudiante() {
    }
    
    public Estudiante(String estudiante, boolean activo) {
        this.nombre = estudiante;
        this.activo = activo;
    }
}
