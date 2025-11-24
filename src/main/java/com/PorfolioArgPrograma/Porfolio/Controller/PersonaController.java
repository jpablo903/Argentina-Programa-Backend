package com.PorfolioArgPrograma.Porfolio.Controller;

import com.PorfolioArgPrograma.Porfolio.Dto.Mensaje;
import com.PorfolioArgPrograma.Porfolio.Dto.PersonaDto;
import com.PorfolioArgPrograma.Porfolio.Entity.Persona;
import com.PorfolioArgPrograma.Porfolio.Service.PersonaService;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/lista/all")
    public ResponseEntity<List<Persona>> listAll(){
        List<Persona> list = personaService.listAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!personaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La persona no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody PersonaDto personaDto){
        // Las validaciones básicas se manejan con @Valid
        // Validaciones adicionales si son necesarias
        if(!StringUtils.hasText(personaDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(personaDto.getApellido()))
            return new ResponseEntity<>(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(personaDto.getProfesion()))
            return new ResponseEntity<>(new Mensaje("La profesión es obligatoria"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(personaDto.getAcercaDe()))
            return new ResponseEntity<>(new Mensaje("Debe incluir información acerca de usted"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(personaDto.getUrlImagenBanner()))
            return new ResponseEntity<>(new Mensaje("El banner es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(), personaDto.getProfesion(),
                personaDto.getUrlImagen(), personaDto.getAcercaDe(), personaDto.getUrlImagenBanner());
        personaService.save(persona);
        return new ResponseEntity<>(new Mensaje("Persona creada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody PersonaDto personaDto){
        if(!personaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La persona no existe"), HttpStatus.NOT_FOUND);
        if(!StringUtils.hasText(personaDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(personaDto.getApellido()))
            return new ResponseEntity<>(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(personaDto.getProfesion()))
            return new ResponseEntity<>(new Mensaje("La profesión es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setProfesion(personaDto.getProfesion());
        persona.setUrlImagen(personaDto.getUrlImagen());
        persona.setAcercaDe(personaDto.getAcercaDe());
        persona.setUrlImagenBanner(personaDto.getUrlImagenBanner());
        personaService.save(persona);
        return new ResponseEntity<>(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!personaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La persona no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity<>(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }    
}
