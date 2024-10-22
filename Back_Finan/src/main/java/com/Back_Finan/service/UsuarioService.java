package com.Back_Finan.service;


import com.Back_Finan.model.Usuario;
import com.Back_Finan.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario crearUsuario(Usuario usuario) {
        // Encriptar la contraseña antes de guardar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Long login(Usuario usuario) {
        Usuario usuario1 = usuarioRepository.findByLogin(usuario.getLogin());
        if (usuario1.getLogin() != null) {
            // Compara la contraseña ingresada con la contraseña encriptada
            Boolean Pass_correc = passwordEncoder.matches(usuario.getPassword(),usuario1.getPassword());
            if(Pass_correc){
                return usuario1.getId_usuario();
            }
            else {
                return 0L;
            }
        }
        return 0L; // Usuario no encontrado
    }
}   