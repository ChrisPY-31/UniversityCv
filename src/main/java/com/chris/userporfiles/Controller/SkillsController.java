package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.SkillsDto;
import com.chris.userporfiles.Model.Entity.Skills;
import com.chris.userporfiles.Service.ProjectService;
import com.chris.userporfiles.Service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/")
@AllArgsConstructor
public class SkillsController {

    private final SkillService skillService;
    private final ProjectService projectService;

    @PostMapping("skills")
    private ResponseEntity<?> saveSkills(@RequestBody SkillsDto skillsDto){
        SkillsDto skills1 = null;
        try {
            if(projectService.existsProject(skillsDto.getIdUserDetails())){
                skills1 = skillService.saveSkills(skillsDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Se agrego correctamente")
                        .object(skills1)
                        .build() , HttpStatus.CREATED);
            }
            return new ResponseEntity<>(Mensaje
                    .builder()
                    .mensaje("Error id no valido")
                    .object(skills1).build() , HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("skills/{id}")
    private ResponseEntity<?> updateSkills(@RequestBody SkillsDto skillsDto, @PathVariable Integer id){
        SkillsDto skillsUpdate = null;
        try{

            if(skillService.existSkills(id) && skillsDto.getId().equals(id)){
                skillsUpdate = skillService.saveSkills(skillsDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Skills actualizo con exito")
                        .object(skillsUpdate)
                        .build(), HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();

        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }


    @DeleteMapping("skills/{id}")
    private ResponseEntity<?> deleteSkills(@PathVariable Integer id){
        SkillsDto skillsDelete = skillService.getSkillsId(id);
        if(skillsDelete != null){
            skillService.deleteSkills(skillsDelete);
            return new ResponseEntity<>(Mensaje
                    .builder()
                    .mensaje("Se elimino con exito")
                    .build() , HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }

}
