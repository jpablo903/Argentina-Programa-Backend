package com.PorfolioArgPrograma.Porfolio.Entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Entity
@Getter
@Setter
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El puesto es obligatorio")
    @Size(max = 100, message = "El puesto no puede exceder 100 caracteres")
    private String puesto;
    
    @NotBlank(message = "El nombre de la compañía es obligatorio")
    @Size(max = 100, message = "El nombre de la compañía no puede exceder 100 caracteres")
    private String nombreCompania;
    
    @Size(max = 500, message = "La URL de imagen no puede exceder 500 caracteres")
    private String imgUrl;
    
    @NotBlank(message = "El lugar es obligatorio")
    @Size(max = 100, message = "El lugar no puede exceder 100 caracteres")
    private String lugar;
    
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    private String descripcion;
    
    public Experiencia() {
    }

    public Experiencia(String puesto, String nombreCompania, String lugar, LocalDate fechaInicio,
            LocalDate fechaFin, String descripcion, String imgUrl) {
        
        this.puesto = puesto;
        this.nombreCompania = nombreCompania;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
    }
}
