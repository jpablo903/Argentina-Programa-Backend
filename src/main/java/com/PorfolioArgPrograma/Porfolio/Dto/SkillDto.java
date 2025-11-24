package com.PorfolioArgPrograma.Porfolio.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Getter
@Setter
public class SkillDto {
    
    @NotBlank(message = "El nombre del skill es obligatorio")
    @Size(max = 100)
    private String nombre;
    
    @NotNull(message = "El porcentaje es obligatorio")
    @Min(value = 0, message = "El porcentaje debe ser al menos 0")
    @Max(value = 100, message = "El porcentaje no puede exceder 100")
    private Integer porcentaje;
    
    @Size(max = 500)
    private String urlImagen;

    public SkillDto() {
    }

    public SkillDto(String nombre, Integer porcentaje, String urlImagen) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.urlImagen = urlImagen;
    }
}
