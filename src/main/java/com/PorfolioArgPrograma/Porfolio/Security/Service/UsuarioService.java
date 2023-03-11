package com.PorfolioArgPrograma.Porfolio.Security.Service;

import com.PorfolioArgPrograma.Porfolio.Segurity.Entity.Usuario;
import com.PorfolioArgPrograma.Porfolio.Segurity.Repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo
 */
@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    } 
    
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
