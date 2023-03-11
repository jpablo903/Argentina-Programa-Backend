package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Estudios;
import com.PorfolioArgPrograma.Porfolio.Repository.EstudiosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Juan Pablo
 */

@Service
@Transactional
public class EstudiosService {
    
    @Autowired
    EstudiosRepository estudiosRepository;
    
    public List<Estudios> list(){
        return estudiosRepository.findAll();
    }
    
     public Optional<Estudios> getOne(int id){
        return estudiosRepository.findById(id);
    }

    
    public void save(Estudios estudio){
        estudiosRepository.save(estudio);
    }

    
    public void delete(int id){
        estudiosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return estudiosRepository.existsById(id);
    }
     
    }

