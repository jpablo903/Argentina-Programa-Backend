package com.PorfolioArgPrograma.Porfolio.Entity;

import java.time.LocalDate;
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
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título de estudios es obligatorio")
    @Size(max = 150, message = "El título no puede exceder 150 caracteres")
    private String tituloEstudios;

    @NotBlank(message = "La institución de estudio es obligatoria")
    @Size(max = 150, message = "La institución no puede exceder 150 caracteres")
    private String institucionEstudio;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Size(max = 500, message = "La URL del logo no puede exceder 500 caracteres")
    private String urlLogo;

    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    private String descripcion;

    public Estudios() {
    }

    public Estudios(String tituloEstudios, String institucionEstudio, LocalDate fechaInicio,
            LocalDate fechaFin, String urlLogo, String descripcion) {

        this.tituloEstudios = tituloEstudios;
        this.institucionEstudio = institucionEstudio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlLogo = urlLogo;
        this.descripcion = descripcion;
    }
}
