package com.PorfolioArgPrograma.Porfolio.Entity;

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
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String puesto;
    private String nombreCompania;
    private String imgUrl;
    private String lugar;
    private String fechaInicio;
    private String fechaFin;
    
    private String descripcion;
    
    
    public Experiencia() {
    }

    public Experiencia(String puesto, String nombreCompania, String lugar, String fechaInicio,
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
