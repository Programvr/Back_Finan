package com.Back_Finan.repository;

import com.Back_Finan.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
