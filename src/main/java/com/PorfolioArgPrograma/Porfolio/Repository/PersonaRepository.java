package com.PorfolioArgPrograma.Porfolio.Repository;

import com.PorfolioArgPrograma.Porfolio.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Juan Pablo
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    
    public void deleteById(int id);

    public boolean existsById(int id);

    public Optional<Persona> findById(int id);

    
    
}
