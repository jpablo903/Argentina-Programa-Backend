package com.PorfolioArgPrograma.Porfolio.Repository;

import com.PorfolioArgPrograma.Porfolio.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Pablo
 */
@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    
}
