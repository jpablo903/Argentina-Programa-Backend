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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

    private String nombre;
    private String apellido;
    private String profesion;
    private String urlImagen;
    private String urlImagenBanner;
    private String acercaDe;
    
    
   
    public Persona() {
    }

    public Persona(String nombre, String apellido, String profesion, String urlImagen, String acercaDe, String urlImagenBanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.urlImagen = urlImagen;
        this.acercaDe = acercaDe;
        this.urlImagenBanner = urlImagenBanner;
    }

   

    
   
}
