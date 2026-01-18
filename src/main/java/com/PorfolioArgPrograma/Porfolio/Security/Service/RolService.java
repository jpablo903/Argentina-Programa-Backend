package com.PorfolioArgPrograma.Porfolio.Security.Service;

import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.PorfolioArgPrograma.Porfolio.Security.Entity.Rol;
import com.PorfolioArgPrograma.Porfolio.Security.Enums.RolNombre;
import com.PorfolioArgPrograma.Porfolio.Security.Repository.RolRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author Juan Pablo
 */

@Service
@Transactional
@RequiredArgsConstructor
public class RolService {

	private final RolRepository rolRepository;

	public Optional<Rol> getByRolNombre(RolNombre roleNombre) {
		return rolRepository.findByRolNombre(roleNombre);
	}

	public void save(Rol rol) {
		rolRepository.save(rol);
	}
}
