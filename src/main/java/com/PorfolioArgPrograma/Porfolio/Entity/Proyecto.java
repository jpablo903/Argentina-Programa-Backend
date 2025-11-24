package com.PorfolioArgPrograma.Porfolio.Entity;

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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre del proyecto es obligatorio")
    @Size(max = 150, message = "El nombre del proyecto no puede exceder 150 caracteres")
    private String nombreProyecto;
    
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    private String descripcion;
    
    @Size(max = 500, message = "La URL de imagen no puede exceder 500 caracteres")
    private String urlImagen;
    
    @Size(max = 500, message = "La URL del proyecto no puede exceder 500 caracteres")
    private String urlProyecto;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcion, String urlImagen, String urlProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.urlProyecto = urlProyecto;
    }
}
