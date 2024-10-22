package com.Back_Finan.service;

import com.Back_Finan.model.Modulo;
import com.Back_Finan.model.Perfil;
import com.Back_Finan.model.PerfilDTO;
import com.Back_Finan.model.Rol;
import com.Back_Finan.model.Usuario;
import com.Back_Finan.repository.PerfilRepository;
import com.Back_Finan.repository.RolRepository;
import com.Back_Finan.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Perfil crearPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<PerfilDTO> obtenerTodosLosPerfiles() {
        return perfilRepository.findPerfiles();
    }

    
    public String eliminarPerfil(Long id_perfil) {
        // Verificar si el perfil existe
        Perfil perfil = perfilRepository.findById(id_perfil)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        // Obtener y eliminar los roles asociados
        List<Rol> roles = rolRepository.findByPerfil(perfil);
        if (!roles.isEmpty()) {
            rolRepository.deleteAll(roles);  // Eliminar todos los roles asociados
        }

        // Eliminar el perfil
        perfilRepository.deleteById(id_perfil);

        return "Perfil y sus roles eliminados correctamente";
    }

    public List<Modulo> obtenerModulosPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        // Obtener los roles asociados al perfil del usuario
        List<Rol> roles = rolRepository.findByPerfil(usuario.getPerfil());

        // Obtener los módulos a través de los roles
        return roles.stream()
                .map(Rol::getModulo) // Suponiendo que tienes un método en Rol que devuelve el módulo
                .distinct()
                .collect(Collectors.toList());
    }
}
