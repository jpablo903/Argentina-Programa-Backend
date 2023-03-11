package com.PorfolioArgPrograma.Porfolio.Controller;

import com.PorfolioArgPrograma.Porfolio.Dto.EstudiosDto;
import com.PorfolioArgPrograma.Porfolio.Dto.Mensaje;
import com.PorfolioArgPrograma.Porfolio.Entity.Estudios;
import com.PorfolioArgPrograma.Porfolio.Service.EstudiosService;
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
@RequestMapping("/estudios")
@CrossOrigin(origins = "*")
public class EstudiosController {
    
    @Autowired
    EstudiosService estudiosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list(){
        List<Estudios> list = estudiosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") int id){
        if(!estudiosService.existsById(id))
            return new ResponseEntity(new Mensaje("Estudio no encontrado!"), HttpStatus.NOT_FOUND);
        Estudios estudios = estudiosService.getOne(id).get();
        return new ResponseEntity(estudios, HttpStatus.OK);
    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody EstudiosDto estudiosDto){
        if(estudiosDto.getTituloEstudios()==null || estudiosDto.getTituloEstudios()=="")
            return new ResponseEntity(new Mensaje("El nombre del estudios es obligatorio."), HttpStatus.BAD_REQUEST);
        if(estudiosDto.getInstitucionEstudio()==null || estudiosDto.getInstitucionEstudio()=="")
            return new ResponseEntity(new Mensaje("El nombre de la institucion es obligatoria."), HttpStatus.BAD_REQUEST);
        if(estudiosDto.getFechaInicio()==null || estudiosDto.getFechaInicio()=="")
            return new ResponseEntity(new Mensaje("La fecha es obligatoria."), HttpStatus.BAD_REQUEST);
        if(estudiosDto.getDescripcion()==null || estudiosDto.getDescripcion()=="")
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria."), HttpStatus.BAD_REQUEST);
        
        Estudios estudios = new Estudios(estudiosDto.getTituloEstudios(), estudiosDto.getInstitucionEstudio(),
                estudiosDto.getFechaInicio(), estudiosDto.getFechaFin(), estudiosDto.getUrlLogo(), estudiosDto.getDescripcion());
        estudiosService.save(estudios);
        return new ResponseEntity(new Mensaje("Estudio agregado exitosamente!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EstudiosDto estudiosDto){
        if(!estudiosService.existsById(id))
            return new ResponseEntity(new Mensaje("El curso no exite."), HttpStatus.NOT_FOUND);
        if(estudiosDto.getTituloEstudios()==null || estudiosDto.getTituloEstudios()=="")
            return new ResponseEntity(new Mensaje("El nombre del estudio es obligatorio."), HttpStatus.BAD_REQUEST);
        if(estudiosDto.getInstitucionEstudio()==null || estudiosDto.getInstitucionEstudio()=="")
            return new ResponseEntity(new Mensaje("La institucion es obligatorio."), HttpStatus.BAD_REQUEST);
        if(estudiosDto.getFechaInicio()==null || estudiosDto.getFechaInicio()=="")
            return new ResponseEntity(new Mensaje("La fecha de obligatorio."), HttpStatus.BAD_REQUEST);
        
        Estudios estudios = estudiosService.getOne(id).get();
        estudios.setTituloEstudios(estudiosDto.getTituloEstudios());
        estudios.setInstitucionEstudio(estudiosDto.getInstitucionEstudio());
        estudios.setFechaInicio(estudiosDto.getFechaInicio());
        estudios.setFechaFin(estudiosDto.getFechaFin());
        estudios.setUrlLogo(estudiosDto.getUrlLogo());
        estudios.setDescripcion(estudiosDto.getDescripcion());
        estudiosService.save(estudios);
        return new ResponseEntity(new Mensaje("Datos Actualizados."), HttpStatus.OK);        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!estudiosService.existsById(id))
            return new ResponseEntity(new Mensaje("El curso no exite."), HttpStatus.NOT_FOUND);
        estudiosService.delete(id);
        return new ResponseEntity(new Mensaje("Curso eliminado."), HttpStatus.OK);
    } 
    
}
