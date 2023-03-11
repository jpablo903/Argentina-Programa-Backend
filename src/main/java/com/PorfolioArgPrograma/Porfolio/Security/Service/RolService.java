package com.PorfolioArgPrograma.Porfolio.Segurity.Service;

import com.PorfolioArgPrograma.Porfolio.Segurity.Entity.Rol;
import com.PorfolioArgPrograma.Porfolio.Segurity.Enums.RolNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PorfolioArgPrograma.Porfolio.Segurity.Repository.RolRepository;

/**
 *
 * @author Juan Pablo
 */

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre roleNombre){
        return rolRepository.findByRolNombre(roleNombre);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
    
}
