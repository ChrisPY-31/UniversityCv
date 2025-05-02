package com.chris.userporfiles.Controller;
import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Entity.Languages;
import com.chris.userporfiles.Service.LanguajesServce;
import com.chris.userporfiles.Service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/")
@AllArgsConstructor
public class LanguajesController {

    private final LanguajesServce languajesServce;
    private final ProjectService projectService;

    @PostMapping("languajes")
    private ResponseEntity<?> saveEducation(@RequestBody Languages languages) {
        Languages languages1  = null;
        try{
            if(projectService.existsProject(languages.getId_UserDetails())){
                languages1 = languajesServce.saveLanguajes(languages);
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
    private ResponseEntity<?> updateEducation(@RequestBody Languages languages , @PathVariable Integer id) {
        Languages languages1  = null;
        try{
            if(languajesServce.existsLanguajes(id) && languages.getId().equals(id)){
                languages1 = languajesServce.saveLanguajes(languages);
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
        Languages languages = languajesServce.getLanguajesById(id);
        if (languages != null) {
            languajesServce.deleteLanguajes(languages);
            return new ResponseEntity<>(Mensaje.builder().mensaje("Atributo elimnado exito").object(null).build() , HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
