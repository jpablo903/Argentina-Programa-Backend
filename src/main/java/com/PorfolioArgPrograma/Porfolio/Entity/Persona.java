package com.PorfolioArgPrograma.Porfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
public class Persona extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @NotBlank(message = "La profesión es obligatoria")
    @Size(max = 100, message = "La profesión no puede exceder 100 caracteres")
    private String profesion;

    @Size(max = 500, message = "La URL de imagen no puede exceder 500 caracteres")
    private String urlImagen;

    @Size(max = 500, message = "La URL de banner no puede exceder 500 caracteres")
    private String urlImagenBanner;

    @NotBlank(message = "La sección 'Acerca de' es obligatoria")
    @Size(max = 5000, message = "La sección 'Acerca de' no puede exceder 1000 caracteres")
    private String acercaDe;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String profesion, String urlImagen, String acercaDe,
            String urlImagenBanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.urlImagen = urlImagen;
        this.acercaDe = acercaDe;
        this.urlImagenBanner = urlImagenBanner;
    }
}
