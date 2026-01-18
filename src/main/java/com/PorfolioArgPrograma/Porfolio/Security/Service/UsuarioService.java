package com.PorfolioArgPrograma.Porfolio.Security.Service;

import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.PorfolioArgPrograma.Porfolio.Security.Entity.Usuario;
import com.PorfolioArgPrograma.Porfolio.Security.Repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author Juan Pablo
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}

	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
