package com.Back_Finan.model;

public class ModuloRolDTO {
    private Long id_modulo;
    private String nombreModulo;
    private boolean escritura;
    private boolean lectura;

    public ModuloRolDTO(Long id_modulo, String nombreModulo, String rol) {
        this.id_modulo = id_modulo;
        this.nombreModulo = nombreModulo;
        this.escritura = "E".equals(rol);
        this.lectura = "L".equals(rol);
    }

    // Getters y setters
    public Long getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(Long id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public boolean isEscritura() {
        return escritura;
    }

    public void setEscritura(boolean escritura) {
        this.escritura = escritura;
    }

    public boolean isLectura() {
        return lectura;
    }

    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }
}

