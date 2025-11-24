package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Proyecto;
import com.PorfolioArgPrograma.Porfolio.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepository;

    public List<Proyecto> list(){
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(Long id){
        return proyectoRepository.findById(id);
    }

    @Transactional
    public void save(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }

    @Transactional
    public void delete(Long id){
        proyectoRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return proyectoRepository.existsById(id);
    }
}
