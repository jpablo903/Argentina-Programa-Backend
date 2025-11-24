package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Skill;
import com.PorfolioArgPrograma.Porfolio.Repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillService {
    @Autowired
    SkillRepository skillRepository;

    public List<Skill> list(){
        return skillRepository.findAll();
    }

    public Optional<Skill> getOne(Long id){
        return skillRepository.findById(id);
    }

    @Transactional
    public void save(Skill skill){
        skillRepository.save(skill);
    }

    @Transactional
    public void delete(Long id){
        skillRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return skillRepository.existsById(id);
    }
}
