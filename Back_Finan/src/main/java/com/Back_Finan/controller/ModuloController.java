package com.Back_Finan.controller;

import com.Back_Finan.model.Modulo;
import com.Back_Finan.model.ModuloRolDTO;
import com.Back_Finan.model.RepuestaString;
import com.Back_Finan.service.ModuloService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://192.168.0.4:8082")
@RequestMapping("/api/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping("/modulosxperfil/{id_perfil}")
    public ResponseEntity<List<ModuloRolDTO>> getModulosByPerfil(@PathVariable long id_perfil) {
        List<ModuloRolDTO> modulos = moduloService.getModulosAndRolesByPerfil(id_perfil);
        return ResponseEntity.ok(modulos);
    }

    @GetMapping("/modulosFaltantes/{id_perfil}")
    public ResponseEntity<List<Modulo>> getModulosFaltantes(@PathVariable long id_perfil) {
        List<Modulo> modulos = moduloService.getModulosFaltantes(id_perfil);
        return ResponseEntity.ok(modulos);
    }

    @PostMapping("/actualizar/{id_perfil}")
    public ResponseEntity<RepuestaString> actualizarModulosPorPerfil(
            @PathVariable long id_perfil,
            @RequestBody List<ModuloRolDTO> nuevosModulos) {
        try {
            moduloService.actualizarModulosPorPerfil(id_perfil, nuevosModulos);
            return ResponseEntity.ok(new RepuestaString("Módulos actualizados correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RepuestaString("Error al actualizar módulos"));
        }
    }
}


    

