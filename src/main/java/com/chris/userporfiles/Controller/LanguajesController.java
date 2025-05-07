package com.chris.userporfiles.Controller;
import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.LanguageDto;
import com.chris.userporfiles.Model.Entity.Languages;
import com.chris.userporfiles.Service.LanguajesServce;
import com.chris.userporfiles.Service.ProjectService;
import com.chris.userporfiles.Service.StudentDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/")
@AllArgsConstructor
public class LanguajesController {

    private final LanguajesServce languajesServce;
    private final StudentDetailsService projectService;

    @PostMapping("languajes")
    private ResponseEntity<?> saveEducation(@RequestBody LanguageDto languageDto) {
        LanguageDto languages1  = null;

        try{
            if(projectService.existStudent(languageDto.getIdUserDetails())){
                languages1 = languajesServce.saveLanguajes(languageDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Se creo con exito")
                        .object(languages1)
                        .build(), HttpStatus.CREATED);
            }
            return ResponseEntity.badRequest().body("Error el proyect Id no existe");
        }catch (Exception e){

            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("languajes/{id}")
    private ResponseEntity<?> updateEducation(@RequestBody LanguageDto languagesDto , @PathVariable Integer id) {
        LanguageDto languages1  = null;
        try{
            if(languajesServce.existsLanguajes(id) && languagesDto.getId().equals(id)){
                languages1 = languajesServce.saveLanguajes(languagesDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Se Actualizo con exito")
                        .object(languages1), HttpStatus.CREATED);
            }
            return ResponseEntity.badRequest().body("Error el proyect Id no existe");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("languajes/{id}")
    private ResponseEntity<?> deleteEducation(@PathVariable Integer id ) {
        LanguageDto languagesDto = languajesServce.getLanguajesById(id);
        if (languagesDto != null) {
            languajesServce.deleteLanguajes(languagesDto);
            return new ResponseEntity<>(Mensaje.builder().mensaje("Atributo elimnado exito").object(null).build() , HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
