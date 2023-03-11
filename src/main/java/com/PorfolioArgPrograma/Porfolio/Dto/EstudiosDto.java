package com.PorfolioArgPrograma.Porfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Getter
@Setter
public class EstudiosDto {
    
    @NotBlank
    private String tituloEstudios;
    @NotBlank
    private String institucionEstudio;
    @NotBlank
    private String fechaInicio;
    private String fechaFin;
    @NotBlank
    private String urlLogo;
    @NotBlank
    private String descripcion;

    public EstudiosDto() {
    }

    public EstudiosDto(String tituloEstudios, String institucionEstudio, String fechaInicio, String fechaFin, String urlLogo, String descripcion) {
        this.tituloEstudios = tituloEstudios;
        this.institucionEstudio = institucionEstudio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlLogo = urlLogo;
        this.descripcion = descripcion;
    }
    
    
}
