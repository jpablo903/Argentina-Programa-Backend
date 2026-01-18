package com.PorfolioArgPrograma.Porfolio.Dto;

import jakarta.validation.constraints.NotBlank;
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
}
