package com.PorfolioArgPrograma.Porfolio.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    private int id;
    private String tituloEstudios;
    private String institucionEstudio;
    private String fechaInicio;
    private String fechaFin;
    private String urlLogo;
    private String descripcion;
    
    
    public Estudios() {
    }


    public Estudios(String tituloEstudios, String institucionEstudio, String fechaInicio,
            String fechaFin, String urlLogo, String descripcion) {
     
        this.tituloEstudios = tituloEstudios;
        this.institucionEstudio = institucionEstudio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlLogo = urlLogo;
        this.descripcion = descripcion;
    }

    
}
