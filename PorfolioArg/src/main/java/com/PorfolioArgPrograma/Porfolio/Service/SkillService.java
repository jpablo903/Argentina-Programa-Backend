package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Skill;
import com.PorfolioArgPrograma.Porfolio.Repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo
 * 
 */

@Service
@Transactional
public class SkillService {
    
    @Autowired
    SkillRepository skillRepository;
    
    public List<Skill> list(){
        return skillRepository.findAll();
    }

    public Optional<Skill> getOne(int id){
        return skillRepository.findById(id);
    }

    public void  save(Skill skill){
        skillRepository.save(skill);
    }

    public void delete(int id){
        skillRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return skillRepository.existsById(id);
    }
}
