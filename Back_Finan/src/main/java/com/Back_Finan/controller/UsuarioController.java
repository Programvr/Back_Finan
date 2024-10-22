package com.Back_Finan.controller;

import com.Back_Finan.model.Usuario;
import com.Back_Finan.service.UsuarioService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario usuario) {
    Long respuesta = usuarioService.login(usuario);
    Map<String, String> responseBody = new HashMap<>();
    responseBody.put("message", respuesta.toString()); // "Inicio Correctamente"
    
    return ResponseEntity.ok(responseBody);
} 

} 