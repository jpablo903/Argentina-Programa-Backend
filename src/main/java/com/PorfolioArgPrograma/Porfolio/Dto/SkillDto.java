package com.PorfolioArgPrograma.Porfolio.Dto;

import com.PorfolioArgPrograma.Porfolio.Entity.Persona;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Getter
@Setter
public class SkillDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String porcentaje;
    @NotBlank
    private String urlImagen;
    //private Persona persona;

    public SkillDto() {
    }

    public SkillDto(String nombre, String porcentaje, String urlImagen) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.urlImagen = urlImagen;
    }
    
    
}
