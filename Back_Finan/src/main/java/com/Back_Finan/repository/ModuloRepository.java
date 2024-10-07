package com.Back_Finan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Back_Finan.model.Modulo;
import com.Back_Finan.model.ModuloRolDTO;

import jakarta.transaction.Transactional;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    
    @Query("SELECT new com.Back_Finan.model.ModuloRolDTO(m.id_modulo,m.nombre_modulo, r.rol) " +
           "FROM Modulo m " +
           "JOIN Rol r ON r.modulo.id_modulo = m.id_modulo " +
           "WHERE r.perfil.id_perfil = :idPerfil")
    List<ModuloRolDTO> findModulosAndRolesByPerfil(@Param("idPerfil") Long idPerfil);

    @Query("SELECT new com.Back_Finan.model.Modulo(m.id_modulo, m.nombre_modulo) " +
       "FROM Modulo m " +
       "WHERE m.id_modulo NOT IN (SELECT r.modulo.id_modulo FROM Rol r WHERE r.perfil.id_perfil = :idPerfil)")
    List<Modulo> findModulosFaltantes(@Param("idPerfil") Long idPerfil);

    @Modifying
    @Transactional
    @Query("UPDATE Rol r SET r.rol = :rol WHERE r.perfil.id = :idPerfil AND r.modulo.id = :idModulo")
    void actualizarRolPorModulo(@Param("rol") String rol, @Param("idPerfil") long idPerfil, @Param("idModulo") long idModulo);


    @Modifying
    @Transactional
    @Query("DELETE FROM Rol r WHERE r.perfil.id = :idPerfil AND r.modulo.id = :idModulo")
    void eliminarModuloPorPerfil(@Param("idPerfil") long idPerfil, @Param("idModulo") long idModulo);
    
}



