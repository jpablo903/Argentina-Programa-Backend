package com.PorfolioArgPrograma.Porfolio.Segurity.Repository;

import com.PorfolioArgPrograma.Porfolio.Segurity.Entity.Rol;
import com.PorfolioArgPrograma.Porfolio.Segurity.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Pablo
 */

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
