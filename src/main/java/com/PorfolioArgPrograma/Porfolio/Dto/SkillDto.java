package com.PorfolioArgPrograma.Porfolio.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
