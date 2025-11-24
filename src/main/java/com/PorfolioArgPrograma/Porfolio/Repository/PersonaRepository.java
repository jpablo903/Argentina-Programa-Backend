package com.PorfolioArgPrograma.Porfolio.Repository;

import com.PorfolioArgPrograma.Porfolio.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Pablo
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // JpaRepository ya proporciona todos los métodos necesarios:
    // findAll(), findById(Long id), save(Persona), deleteById(Long id), existsById(Long id)
}
