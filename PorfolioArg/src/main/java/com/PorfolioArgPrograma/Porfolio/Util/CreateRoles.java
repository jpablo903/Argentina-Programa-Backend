package com.PorfolioArgPrograma.Porfolio.CreateRoles;

import com.PorfolioArgPrograma.Porfolio.Segurity.Entity.Rol;
import com.PorfolioArgPrograma.Porfolio.Segurity.Enums.RolNombre;
import com.PorfolioArgPrograma.Porfolio.Segurity.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Pablo
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
    //    Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
    //    Rol rolUser = new Rol(RolNombre.ROLE_USER);
    //    rolService.save(rolAdmin);
    //    rolService.save(rolUser);
    //    
        
    }
}
