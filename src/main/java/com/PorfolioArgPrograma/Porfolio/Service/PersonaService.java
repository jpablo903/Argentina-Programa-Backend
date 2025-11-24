package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Persona;
import com.PorfolioArgPrograma.Porfolio.Repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Pablo
 */

@Slf4j
@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    
    public List<Persona> listAll(){
        log.debug("Listando todas las personas");
        return personaRepository.findAll();
    }

    public Optional<Persona> getOne(Long id){
        return personaRepository.findById(id);
    }

    @Transactional
    public void save(Persona persona){
        log.info("Guardando persona: {} {}", persona.getNombre(), persona.getApellido());
        personaRepository.save(persona);
    }

    @Transactional
    public void delete(Long id){
        log.info("Eliminando persona con ID: {}", id);
        personaRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return personaRepository.existsById(id);
    }
}
