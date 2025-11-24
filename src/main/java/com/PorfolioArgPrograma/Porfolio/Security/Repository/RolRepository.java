package com.PorfolioArgPrograma.Porfolio.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PorfolioArgPrograma.Porfolio.Security.Entity.Rol;
import com.PorfolioArgPrograma.Porfolio.Security.Enums.RolNombre;

/**
 *
 * @author Juan Pablo
 */

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
