package com.PorfolioArgPrograma.Porfolio.Controller;

import com.PorfolioArgPrograma.Porfolio.Dto.Mensaje;
import com.PorfolioArgPrograma.Porfolio.Dto.ProyectoDto;
import com.PorfolioArgPrograma.Porfolio.Entity.Proyecto;
import com.PorfolioArgPrograma.Porfolio.Service.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Pablo
 */

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "*")
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("Proyecto no encontrado!"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ProyectoDto proyectoDto){
        if(proyectoDto.getNombreProyecto()==null || proyectoDto.getNombreProyecto()=="")
            return new ResponseEntity(new Mensaje("Nombre del proyecto obligatorio."), HttpStatus.BAD_REQUEST);
        if(proyectoDto.getDescripcion()==null || proyectoDto.getDescripcion()=="")
            return new ResponseEntity(new Mensaje("Descripcion obligatoria."), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(proyectoDto.getNombreProyecto(),proyectoDto.getDescripcion(),
                proyectoDto.getUrlImagen(), proyectoDto.getUrlProyecto());
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado exitosamente!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")   
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectoDto proyectoDto){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no exite."), HttpStatus.NOT_FOUND);
        if(proyectoDto.getNombreProyecto()==null || proyectoDto.getNombreProyecto()=="")
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
        if(proyectoDto.getDescripcion()==null || proyectoDto.getDescripcion()=="")
            return new ResponseEntity(new Mensaje("Drescripcion obligatorio."), HttpStatus.BAD_REQUEST);
        
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setNombreProyecto(proyectoDto.getNombreProyecto());
        proyecto.setDescripcion(proyectoDto.getDescripcion());
        proyecto.setUrlImagen(proyectoDto.getUrlImagen());
        proyecto.setUrlProyecto(proyectoDto.getUrlProyecto());

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Datos Actualizados."), HttpStatus.OK);        
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no exite."), HttpStatus.NOT_FOUND);
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado."), HttpStatus.OK);
    } 
}
