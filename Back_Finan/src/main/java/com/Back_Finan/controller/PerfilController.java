package com.Back_Finan.controller;

import com.Back_Finan.model.Perfil;
import com.Back_Finan.service.PerfilService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public ResponseEntity<Perfil> crearPerfil(@RequestBody Perfil perfil) {
        Perfil nuevoPerfil = perfilService.crearPerfil(perfil);
        return ResponseEntity.ok(nuevoPerfil);
    }

    @GetMapping
    public List<Perfil> obtenerPerfiles() {
        return perfilService.obtenerTodosLosPerfiles();
    }

    @DeleteMapping("/{id_perfil}")
    public ResponseEntity<String> eliminarPerfil(@PathVariable long id_perfil) {
    String resultado = perfilService.eliminarPerfil(id_perfil);
    return ResponseEntity.ok(resultado);
    }
    
}
