package com.PorfolioArgPrograma.Porfolio.Controller;

import com.PorfolioArgPrograma.Porfolio.Dto.ExperienciaDto;
import com.PorfolioArgPrograma.Porfolio.Dto.Mensaje;
import com.PorfolioArgPrograma.Porfolio.Entity.Experiencia;
import com.PorfolioArgPrograma.Porfolio.Service.ExperienciaService;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
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
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("Experiencia no encontrada"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody ExperienciaDto experienciaDto){
        if(!StringUtils.hasText(experienciaDto.getPuesto()))
            return new ResponseEntity<>(new Mensaje("El nombre del puesto es requerido"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(experienciaDto.getNombreCompania()))
            return new ResponseEntity<>(new Mensaje("El nombre de la compañía es requerido"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(experienciaDto.getLugar()))
            return new ResponseEntity<>(new Mensaje("El lugar es obligatorio"), HttpStatus.BAD_REQUEST);
        
        try {
            LocalDate fechaInicio = StringUtils.hasText(experienciaDto.getFechaInicio()) 
                ? LocalDate.parse(experienciaDto.getFechaInicio()) 
                : null;
            LocalDate fechaFin = StringUtils.hasText(experienciaDto.getFechaFin()) 
                ? LocalDate.parse(experienciaDto.getFechaFin()) 
                : null;
            
            Experiencia experiencia = new Experiencia(experienciaDto.getPuesto(), experienciaDto.getNombreCompania(),
                    experienciaDto.getLugar(), fechaInicio, fechaFin,
                    experienciaDto.getDescripcion(), experienciaDto.getImgUrl());
            experienciaService.save(experiencia);
            return new ResponseEntity<>(new Mensaje("Experiencia agregada exitosamente"), HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>(new Mensaje("Formato de fecha inválido. Use yyyy-MM-dd"), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody ExperienciaDto experienciaDto){
        if(!experienciaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La experiencia no existe"), HttpStatus.NOT_FOUND);
        
        try {
            Experiencia experiencia = experienciaService.getOne(id).get();
            experiencia.setPuesto(experienciaDto.getPuesto());
            experiencia.setNombreCompania(experienciaDto.getNombreCompania());
            experiencia.setLugar(experienciaDto.getLugar());
            experiencia.setFechaInicio(StringUtils.hasText(experienciaDto.getFechaInicio()) 
                ? LocalDate.parse(experienciaDto.getFechaInicio()) 
                : null);
            experiencia.setFechaFin(StringUtils.hasText(experienciaDto.getFechaFin()) 
                ? LocalDate.parse(experienciaDto.getFechaFin()) 
                : null);
            experiencia.setDescripcion(experienciaDto.getDescripcion());
            experiencia.setImgUrl(experienciaDto.getImgUrl());
            experienciaService.save(experiencia);
            return new ResponseEntity<>(new Mensaje("Datos actualizados"), HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>(new Mensaje("Formato de fecha inválido. Use yyyy-MM-dd"), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La experiencia no existe"), HttpStatus.NOT_FOUND);
        experienciaService.delete(id);
        return new ResponseEntity<>(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    } 
}
