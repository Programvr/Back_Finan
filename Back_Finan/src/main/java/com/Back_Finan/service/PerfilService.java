package com.Back_Finan.service;

import com.Back_Finan.model.Perfil;
import com.Back_Finan.model.Rol;
import com.Back_Finan.repository.PerfilRepository;
import com.Back_Finan.repository.RolRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private RolRepository rolRepository;


    public Perfil crearPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<Perfil> obtenerTodosLosPerfiles() {
        return perfilRepository.findAll();
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
}
