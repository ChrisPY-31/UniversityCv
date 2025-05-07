package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.AptitudesDto;
import com.chris.userporfiles.Model.Entity.Aptitudes;
import com.chris.userporfiles.Service.AptitudesService;
import com.chris.userporfiles.Service.ProjectService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class AptitudesController {

    private final AptitudesService aptitudesService;

    private final ProjectService projectService;

    @GetMapping("aptitudes")
    public ResponseEntity<?> getAllAptitudes(){
        return ResponseEntity.ok(aptitudesService.getAptitudes());
    }

    @PostMapping("aptitudes")
    private ResponseEntity<?> saveAptitudes(@RequestBody AptitudesDto aptitudesDto) {

        AptitudesDto saveAptitud = null;
        try {
            System.out.println(aptitudesDto.getNameAptitude() +" desde controller");
            if (projectService.existsProject(aptitudesDto.getIdProject())) {
                saveAptitud = aptitudesService.saveAptitudes(aptitudesDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("aptitudes creado con exito")
                        .object(saveAptitud)
                        .build()
                        , HttpStatus.CREATED);
            }
            return new ResponseEntity<>(Mensaje.builder().mensaje("El id del proyecto no exite").object(null).build(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("aptitudes/{id}")
    private ResponseEntity<?> updateAptitudes(@RequestBody AptitudesDto aptitudesDto, @PathVariable Integer id) {
        AptitudesDto updateAptitud = null;
        try {
            if (aptitudesService.existAptitudes(id)) {
                updateAptitud = aptitudesService.saveAptitudes(aptitudesDto);
                return new ResponseEntity<>(Mensaje.builder().mensaje("Aptitud modificada con exito").object(updateAptitud).build(), HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("aptitudes/{id}")
    private ResponseEntity<?> deleteAptitudes(@PathVariable Integer id) {
        AptitudesDto deleteAptitud = aptitudesService.aptitudGetId(id);
        if (deleteAptitud != null) {
            aptitudesService.deleteAptitudes(deleteAptitud);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
