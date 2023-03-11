package com.PorfolioArgPrograma.Porfolio.Controller;

import com.PorfolioArgPrograma.Porfolio.Dto.ExperienciaDto;
import com.PorfolioArgPrograma.Porfolio.Dto.Mensaje;
import com.PorfolioArgPrograma.Porfolio.Entity.Experiencia;
import com.PorfolioArgPrograma.Porfolio.Service.ExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {
    
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("Estudio no encontrado!"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ExperienciaDto experienciaDto){
        if(experienciaDto.getPuesto()==null || experienciaDto.getPuesto()=="")
            return new ResponseEntity(new Mensaje("El nombre del puesto es requerido."), HttpStatus.BAD_REQUEST);
        if(experienciaDto.getNombreCompania()==null || experienciaDto.getNombreCompania()=="")
            return new ResponseEntity(new Mensaje("El nombre es requerido."), HttpStatus.BAD_REQUEST);
        if(experienciaDto.getLugar()==null || experienciaDto.getLugar()=="")
            return new ResponseEntity(new Mensaje("El lugar es obligatorio."), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(experienciaDto.getPuesto(), experienciaDto.getNombreCompania(),
                experienciaDto.getLugar(), experienciaDto.getFechaInicio(), experienciaDto.getFechaFin(),
                experienciaDto.getDescripcion(), experienciaDto.getImgUrl());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Estudio agregado exitosamete!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ExperienciaDto experienciaDto){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia no exite."), HttpStatus.NOT_FOUND);
        
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setPuesto(experienciaDto.getPuesto());
        experiencia.setNombreCompania(experienciaDto.getNombreCompania());
        experiencia.setLugar(experienciaDto.getLugar());
        experiencia.setFechaInicio(experienciaDto.getFechaInicio());
        experiencia.setFechaFin(experienciaDto.getFechaFin());
        experiencia.setDescripcion(experienciaDto.getDescripcion());
        experiencia.setImgUrl(experienciaDto.getImgUrl());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Datos Actualizados."), HttpStatus.OK);        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia no exite."), HttpStatus.NOT_FOUND);
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Datos eliminado."), HttpStatus.OK);
    } 
}
