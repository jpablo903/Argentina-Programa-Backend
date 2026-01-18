package com.PorfolioArgPrograma.Porfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Pablo
 */

@Entity
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del skill es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String nombre;

    @NotNull(message = "El porcentaje es obligatorio")
    @Min(value = 0, message = "El porcentaje debe ser al menos 0")
    @Max(value = 100, message = "El porcentaje no puede exceder 100")
    private Integer porcentaje;

    @Size(max = 500, message = "La URL de imagen no puede exceder 500 caracteres")
    private String urlImagen;

    public Skill() {
    }

    public Skill(String nombre, Integer porcentaje, String urlImagen) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.urlImagen = urlImagen;
    }
}
