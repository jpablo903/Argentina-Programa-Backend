package com.PorfolioArgPrograma.Porfolio.Controller;

import com.PorfolioArgPrograma.Porfolio.Dto.Mensaje;
import com.PorfolioArgPrograma.Porfolio.Dto.SkillDto;
import com.PorfolioArgPrograma.Porfolio.Entity.Skill;
import com.PorfolioArgPrograma.Porfolio.Service.SkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "*")
public class SkillController {
    
    @Autowired
    SkillService skillService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("Skill no encontrado!"), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody SkillDto skillDto){
        if(skillDto.getNombre()==null || skillDto.getNombre()=="")
            return new ResponseEntity(new Mensaje("Nombre del skill obligatorio."), HttpStatus.BAD_REQUEST);
        if(skillDto.getPorcentaje()==null || skillDto.getPorcentaje()=="")
            return new ResponseEntity(new Mensaje("Valor de skill obligatorio."), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(skillDto.getNombre(),skillDto.getPorcentaje(),
                skillDto.getUrlImagen());
        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Skill agregado exitosamente!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody SkillDto skillDto){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("El skill no exite."), HttpStatus.NOT_FOUND);
        if(skillDto.getNombre()==null || skillDto.getNombre()=="")
            return new ResponseEntity(new Mensaje("El nombre del skill es obligatorio."), HttpStatus.BAD_REQUEST);
        if(skillDto.getPorcentaje()==null || skillDto.getPorcentaje()=="")
            return new ResponseEntity(new Mensaje("Valor de skill obligatorio."), HttpStatus.BAD_REQUEST);
        
        
        Skill skill = skillService.getOne(id).get();
        skill.setNombre(skillDto.getNombre());
        skill.setPorcentaje(skillDto.getPorcentaje());
        skill.setUrlImagen(skillDto.getUrlImagen());
        
        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Skill Actualizado."), HttpStatus.OK);        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("El skill no exite."), HttpStatus.NOT_FOUND);
        skillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado."), HttpStatus.OK);
    }
}
