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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProyecto;
    private String descripcion;
    private String urlImagen;
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
