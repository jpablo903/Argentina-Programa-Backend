package com.PorfolioArgPrograma.Porfolio.Controller;

import com.PorfolioArgPrograma.Porfolio.Dto.EstudiosDto;
import com.PorfolioArgPrograma.Porfolio.Dto.Mensaje;
import com.PorfolioArgPrograma.Porfolio.Entity.Estudios;
import com.PorfolioArgPrograma.Porfolio.Service.EstudiosService;
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
@RequestMapping("/estudios")
@CrossOrigin(origins = "*")
public class EstudiosController {
    
    @Autowired
    EstudiosService estudiosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list(){
        List<Estudios> list = estudiosService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!estudiosService.existsById(id))
            return new ResponseEntity<>(new Mensaje("Estudio no encontrado"), HttpStatus.NOT_FOUND);
        Estudios estudios = estudiosService.getOne(id).get();
        return new ResponseEntity<>(estudios, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody EstudiosDto estudiosDto){
        if(!StringUtils.hasText(estudiosDto.getTituloEstudios()))
            return new ResponseEntity<>(new Mensaje("El título de estudios es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(estudiosDto.getInstitucionEstudio()))
            return new ResponseEntity<>(new Mensaje("El nombre de la institución es obligatorio"), HttpStatus.BAD_REQUEST);
        
        try {
            LocalDate fechaInicio = StringUtils.hasText(estudiosDto.getFechaInicio()) 
                ? LocalDate.parse(estudiosDto.getFechaInicio()) 
                : null;
            LocalDate fechaFin = StringUtils.hasText(estudiosDto.getFechaFin()) 
                ? LocalDate.parse(estudiosDto.getFechaFin()) 
                : null;
            
            Estudios estudios = new Estudios(estudiosDto.getTituloEstudios(), estudiosDto.getInstitucionEstudio(),
                    fechaInicio, fechaFin, estudiosDto.getUrlLogo(), estudiosDto.getDescripcion());
            estudiosService.save(estudios);
            return new ResponseEntity<>(new Mensaje("Estudio agregado exitosamente"), HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>(new Mensaje("Formato de fecha inválido. Use yyyy-MM-dd"), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody EstudiosDto estudiosDto){
        if(!estudiosService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El estudio no existe"), HttpStatus.NOT_FOUND);
        if(!StringUtils.hasText(estudiosDto.getTituloEstudios()))
            return new ResponseEntity<>(new Mensaje("El título de estudios es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(estudiosDto.getInstitucionEstudio()))
            return new ResponseEntity<>(new Mensaje("La institución es obligatoria"), HttpStatus.BAD_REQUEST);
        
        try {
            Estudios estudios = estudiosService.getOne(id).get();
            estudios.setTituloEstudios(estudiosDto.getTituloEstudios());
            estudios.setInstitucionEstudio(estudiosDto.getInstitucionEstudio());
            estudios.setFechaInicio(StringUtils.hasText(estudiosDto.getFechaInicio()) 
                ? LocalDate.parse(estudiosDto.getFechaInicio()) 
                : null);
            estudios.setFechaFin(StringUtils.hasText(estudiosDto.getFechaFin()) 
                ? LocalDate.parse(estudiosDto.getFechaFin()) 
                : null);
            estudios.setUrlLogo(estudiosDto.getUrlLogo());
            estudios.setDescripcion(estudiosDto.getDescripcion());
            estudiosService.save(estudios);
            return new ResponseEntity<>(new Mensaje("Datos actualizados"), HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>(new Mensaje("Formato de fecha inválido. Use yyyy-MM-dd"), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!estudiosService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El estudio no existe"), HttpStatus.NOT_FOUND);
        estudiosService.delete(id);
        return new ResponseEntity<>(new Mensaje("Estudio eliminado"), HttpStatus.OK);
    } 
}
