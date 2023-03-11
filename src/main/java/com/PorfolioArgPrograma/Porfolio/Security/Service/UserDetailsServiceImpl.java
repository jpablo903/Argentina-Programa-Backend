package com.PorfolioArgPrograma.Porfolio.Segurity.Service;

import com.PorfolioArgPrograma.Porfolio.Security.Service.UsuarioService;
import com.PorfolioArgPrograma.Porfolio.Segurity.Entity.Usuario;
import com.PorfolioArgPrograma.Porfolio.Segurity.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
       Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
       return UsuarioPrincipal.build(usuario);
    }
    
   
}
