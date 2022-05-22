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

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String profesion,
            String urlImagen, String acercaDe, String urlImagenBanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.urlImagen = urlImagen;
        this.acercaDe = acercaDe;
        this.urlImagenBanner = urlImagenBanner;
    }
}
