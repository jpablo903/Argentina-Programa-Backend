package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Estudios;
import com.PorfolioArgPrograma.Porfolio.Repository.EstudiosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudiosService {
    @Autowired
    EstudiosRepository estudiosRepository;

    public List<Estudios> list(){
        return estudiosRepository.findAll();
    }

    public Optional<Estudios> getOne(Long id){
        return estudiosRepository.findById(id);
    }

    @Transactional
    public void save(Estudios estudios){
        estudiosRepository.save(estudios);
    }

    @Transactional
    public void delete(Long id){
        estudiosRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return estudiosRepository.existsById(id);
    }
}
