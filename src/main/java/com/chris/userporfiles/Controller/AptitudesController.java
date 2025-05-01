package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
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

    @PostMapping("aptitudes")
    private ResponseEntity<?> saveAptitudes(@RequestBody Aptitudes aptitudes) {

        Aptitudes aptitud = null;
        try {
            if (projectService.existsProject(aptitudes.getIdProject())) {
                aptitud = aptitudesService.saveAptitudes(aptitudes);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("aptitudes creado con exito")
                        .object(aptitud)
                        .build()
                        , HttpStatus.CREATED);
            }
            return new ResponseEntity<>(Mensaje.builder().mensaje("El id del proyecto no exite").object(null).build(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("aptitudes/{id}")
    private ResponseEntity<?> updateAptitudes(@RequestBody Aptitudes aptitudes, @PathVariable Integer id) {
        Aptitudes updateAptitud = null;
        try {
            if (aptitudesService.existAptitudes(id)) {
                updateAptitud = aptitudesService.saveAptitudes(aptitudes);
                return new ResponseEntity<>(Mensaje.builder().mensaje("Aptitud modificada con exito").object(updateAptitud).build(), HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("aptitudes/{id}")
    private ResponseEntity<?> deleteAptitudes(@PathVariable Integer id) {
        Aptitudes aptitud = aptitudesService.aptitudGetId(id);
        if (aptitud != null) {
            aptitudesService.deleteAptitudes(aptitud);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
