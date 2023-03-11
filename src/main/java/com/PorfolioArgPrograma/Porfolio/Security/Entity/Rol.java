package com.PorfolioArgPrograma.Porfolio.Segurity.Entity;

import com.PorfolioArgPrograma.Porfolio.Segurity.Enums.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juan Pablo
 */

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    public Rol(){
    }
    
    public Rol(@NotNull RolNombre rolNombre){
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRoleName() {
        return rolNombre;
    }

    public void setRoleName(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    
    
}
