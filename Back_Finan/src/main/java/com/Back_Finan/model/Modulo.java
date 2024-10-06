package com.Back_Finan.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Modulos")
public class Modulo {

    @OneToMany(mappedBy = "modulo")
    private List<Rol> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modulo;

    private String nombre_modulo;

    // Constructor vacío necesario para Hibernate
    public Modulo() {
    }

    // Constructor con parámetros
    public Modulo(Long id_modulo, String nombre_modulo) {
        this.id_modulo = id_modulo;
        this.nombre_modulo = nombre_modulo;
    }

    // Getters y setters
    public Long getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(Long id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }

    public void setNombre_modulo(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }
}
