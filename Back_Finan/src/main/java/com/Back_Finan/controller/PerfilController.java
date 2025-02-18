package com.Back_Finan.controller;

import com.Back_Finan.model.Modulo;
import com.Back_Finan.model.Perfil;
import com.Back_Finan.model.PerfilDTO;
import com.Back_Finan.service.PerfilService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://192.168.0.4:8082")
@RequestMapping("/api/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping("/crearPerfil")
    public ResponseEntity<Perfil> crearPerfil(@RequestBody Perfil perfil) {
        Perfil nuevoPerfil = perfilService.crearPerfil(perfil);
        return ResponseEntity.ok(nuevoPerfil);
    }

    @GetMapping("/obtenerPerfiles")
    public List<PerfilDTO> obtenerPerfiles() {
        return perfilService.obtenerTodosLosPerfiles();
    }

    @DeleteMapping("/{id_perfil}")
    public ResponseEntity<String> eliminarPerfil(@PathVariable long id_perfil) {
    String resultado = perfilService.eliminarPerfil(id_perfil);
    return ResponseEntity.ok(resultado);
    }
    
    @GetMapping("/modulosPorUsuario/{usuarioId}")
    public ResponseEntity<List<Modulo>> obtenerModulosPorUsuario(@PathVariable Long usuarioId) {
        List<Modulo> modulos = perfilService.obtenerModulosPorUsuario(usuarioId);
        return ResponseEntity.ok(modulos);
    }
}
