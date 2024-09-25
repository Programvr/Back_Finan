package com.Back_Finan.service;

import com.Back_Finan.model.Perfil;
import com.Back_Finan.repository.PerfilRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;


    public Perfil crearPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<Perfil> obtenerTodosLosPerfiles() {
        return perfilRepository.findAll();
    }
}
