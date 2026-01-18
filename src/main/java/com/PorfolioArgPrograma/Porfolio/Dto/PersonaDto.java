package com.PorfolioArgPrograma.Porfolio.Dto;

import jakarta.validation.constraints.NotBlank;
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
public class PersonaDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String profesion;
    @NotBlank
    private String urlImagen;

    @NotBlank
    private String acercaDe;

    @NotBlank
    private String urlImagenBanner;
}
