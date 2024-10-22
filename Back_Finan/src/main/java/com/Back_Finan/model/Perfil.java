package com.Back_Finan.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Long id_perfil;

    private String nombre;

    @OneToMany(mappedBy = "perfil")
    private List<Rol> roles;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuario;
    

    // Getters y setters
    public Long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    public List<Usuario> getUsuario() {
        return usuario;
    }
    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
}
