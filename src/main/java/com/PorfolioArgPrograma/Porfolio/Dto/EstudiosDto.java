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
public class EstudiosDto {

    @NotBlank
    private String tituloEstudios;
    @NotBlank
    private String institucionEstudio;
    @NotBlank
    private String fechaInicio;
    private String fechaFin;
    private String urlLogo;
    private String descripcion;
}
