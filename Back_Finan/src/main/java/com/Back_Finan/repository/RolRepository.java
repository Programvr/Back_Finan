package com.Back_Finan.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Back_Finan.model.Perfil;
import com.Back_Finan.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
    List<Rol> findByPerfil(Perfil perfil);


}
