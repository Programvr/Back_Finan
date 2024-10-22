package com.Back_Finan.repository;


import com.Back_Finan.model.Perfil;
import com.Back_Finan.model.PerfilDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
    @Query("SELECT new com.Back_Finan.model.PerfilDTO(p.id_perfil, p.nombre) " +
       "FROM Perfil p ")
    List<PerfilDTO> findPerfiles();

}
