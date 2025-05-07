package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.EducationDto;
import com.chris.userporfiles.Model.Entity.Education;
import com.chris.userporfiles.Service.EducationService;
import com.chris.userporfiles.Service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/")
@AllArgsConstructor
public class EducationController {

    private final EducationService educationService;
    private final ProjectService projectService;

    @PostMapping("education")
    private ResponseEntity<?> saveEducation(@RequestBody EducationDto educationDto) {
        EducationDto educacion1Dto = null;

        try{
            if(projectService.existsProject(educationDto.getIdUserDetails())){
                educacion1Dto = educationService.saveEducation(educationDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Se creo con exito")
                        .object(educacion1Dto)
                        .build(), HttpStatus.CREATED);
            }
            return ResponseEntity.badRequest().body("Error el proyect Id no existe");
        }catch (Exception e){

        return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("education/{id}")
    private ResponseEntity<?> updateEducation(@RequestBody EducationDto educationDto , @PathVariable Integer id) {
        EducationDto educacion1 = null;
        try{
            if(educationService.existsEducation(id) && educationDto.getId().equals(educationDto.getIdUserDetails())){
                educacion1 = educationService.saveEducation(educationDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Se Actualizo con exito")
                        .object(educacion1).build(), HttpStatus.CREATED);
            }
            return ResponseEntity.badRequest().body("Error el proyect Id no existe");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("education/{id}")
    private ResponseEntity<?> deleteEducation(@PathVariable Integer id ) {
        EducationDto education = educationService.getEducationId(id);
        if (education != null) {
            educationService.deleteEducation(education);
            return new ResponseEntity<>(Mensaje
                    .builder()
                    .mensaje("Atributo elimnado exito")
                    .object(null)
                    .build() , HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
