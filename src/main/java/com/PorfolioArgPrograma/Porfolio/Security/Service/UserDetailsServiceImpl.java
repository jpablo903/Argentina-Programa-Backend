package com.PorfolioArgPrograma.Porfolio.Security.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PorfolioArgPrograma.Porfolio.Security.Entity.Usuario;
import com.PorfolioArgPrograma.Porfolio.Security.Entity.UsuarioPrincipal;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author Juan Pablo
 */

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario));
		return UsuarioPrincipal.build(usuario);
	}
}
