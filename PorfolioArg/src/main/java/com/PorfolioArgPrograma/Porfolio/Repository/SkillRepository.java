package com.PorfolioArgPrograma.Porfolio.Repository;

import com.PorfolioArgPrograma.Porfolio.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Pablo
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    
}
