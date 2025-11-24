package com.PorfolioArgPrograma.Porfolio.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Getter
@Setter
public class ExperienciaDto {
    
    @NotBlank(message = "El puesto es obligatorio")
    @Size(max = 100)
    private String puesto;
    
    @NotBlank(message = "El nombre de la compañía es obligatorio")
    @Size(max = 100)
    private String nombreCompania;
    
    @NotBlank(message = "El lugar es obligatorio")
    @Size(max = 100)
    private String lugar;
    
    // Fechas en formato ISO (yyyy-MM-dd) para ser parseadas a LocalDate
    private String fechaInicio;
    private String fechaFin;
    
    @Size(max = 1000)
    private String descripcion;
    
    @Size(max = 500)
    private String imgUrl;

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
