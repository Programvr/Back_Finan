package com.Back_Finan.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Back_Finan.model.Modulo;
import com.Back_Finan.model.ModuloRolDTO;
import com.Back_Finan.model.Perfil;
import com.Back_Finan.model.Rol;
import com.Back_Finan.repository.ModuloRepository;
import com.Back_Finan.repository.PerfilRepository;
import com.Back_Finan.repository.RolRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private RolRepository rolRepository;

    public List<ModuloRolDTO> getModulosAndRolesByPerfil(Long idPerfil) {
        return moduloRepository.findModulosAndRolesByPerfil(idPerfil);
    }

    public List<Modulo> getModulosFaltantes(Long idPerfil) {
        return moduloRepository.findModulosFaltantes(idPerfil);
    }

    public void actualizarModulosPorPerfil(long id_perfil, List<ModuloRolDTO> nuevosModulos) {
        


        // Obtener módulos actuales de la base de datos
        List<ModuloRolDTO> modulosActuales = getModulosAndRolesByPerfil(id_perfil);

        // Convertir la lista de módulos actuales a un Set para facilitar la comparación
        Set<Long> idsModulosActuales = modulosActuales.stream()
                .map(ModuloRolDTO::getId_modulo)
                .collect(Collectors.toSet());

        // Actualizar o eliminar módulos
        for (ModuloRolDTO nuevoModulo : nuevosModulos) {
            String rol = "";
            Perfil perfil = perfilRepository.findById(id_perfil)
                .orElseThrow(() -> new EntityNotFoundException("Perfil no encontrado"));
        
            Modulo modulo = moduloRepository.findById(nuevoModulo.getId_modulo())
                .orElseThrow(() -> new EntityNotFoundException("Módulo no encontrado"));
            if(nuevoModulo.isLectura()){
                rol = "L";
            }
            if(nuevoModulo.isEscritura()){
                rol = "E";
            }
            if (idsModulosActuales.contains(nuevoModulo.getId_modulo())) {
                // El módulo ya existe, actualiza los permisos
                moduloRepository.actualizarRolPorModulo(rol, id_perfil, nuevoModulo.getId_modulo());
            } else {
                
                // El módulo es nuevo, añadir a la base de datos
                System.out.println("else");
                Rol nuevoRol = new Rol();
                    nuevoRol.setPerfil(perfil);
                    nuevoRol.setModulo(modulo);
                    nuevoRol.setRol(rol);
                    rolRepository.save(nuevoRol);
            }
        }

        // Eliminar módulos que ya no están en la nueva lista
        for (ModuloRolDTO moduloActual : modulosActuales) {
            if (!nuevosModulos.stream().anyMatch(nuevoModulo -> nuevoModulo.getId_modulo().equals(moduloActual.getId_modulo()))) {
                // Si el módulo actual no está en la nueva lista, eliminar
                moduloRepository.eliminarModuloPorPerfil(id_perfil, moduloActual.getId_modulo());
            }
        }
    }
}

