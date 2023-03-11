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
public class ExperienciaDto {
    
    @NotBlank
    private String puesto;
    @NotBlank
    private String nombreCompania;
    @NotBlank
    private String lugar;
    @NotBlank
    private String fechaInicio;
    private String fechaFin;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imgUrl;
    //private Persona persona;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String puesto, String nombreCompania, String lugar, String fechaInicio,
            String fechaFin, String descripcion, String imgUrl) {
        this.puesto = puesto;
        this.nombreCompania = nombreCompania;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
    }   
    
    
}
