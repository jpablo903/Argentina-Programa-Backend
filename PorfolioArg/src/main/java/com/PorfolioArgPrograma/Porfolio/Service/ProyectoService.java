package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Proyecto;
import com.PorfolioArgPrograma.Porfolio.Repository.ProyectoRepository;
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
public class ProyectoService {
    
    @Autowired
    ProyectoRepository proyectoRepository;
    
    public List<Proyecto> list(){
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(int id){
        return proyectoRepository.findById(id);
    }

    public void  save(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }

    public void delete(int id){
        proyectoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return proyectoRepository.existsById(id);
    }
}
