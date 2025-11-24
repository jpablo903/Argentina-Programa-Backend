package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Experiencia;
import com.PorfolioArgPrograma.Porfolio.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;

    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(Long id){
        return experienciaRepository.findById(id);
    }

    @Transactional
    public void save(Experiencia experiencia){
        log.info("Guardando experiencia: {}", experiencia.getPuesto());
        experienciaRepository.save(experiencia);
    }

    @Transactional
    public void delete(Long id){
        experienciaRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return experienciaRepository.existsById(id);
    }
}
