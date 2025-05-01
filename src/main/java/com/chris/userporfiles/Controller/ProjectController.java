package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Entity.Projects;
import com.chris.userporfiles.Service.ProjectService;
import com.chris.userporfiles.Service.StudentDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final StudentDetailsService studentDetailsService;

    @GetMapping("proyectos")
    private ResponseEntity<?> getAllProyects() {
        List<Projects> proyect = projectService.getAllProjects();
        if (!proyect.isEmpty()) {
            return new ResponseEntity<>(Mensaje.builder().mensaje("").object(proyect).build(), HttpStatus.OK);
        }
        //corregir con las excepciones
        return new ResponseEntity<>(Mensaje.builder().mensaje("").object(null).build(), HttpStatus.NOT_FOUND);

    }

    @PostMapping("proyectos")
    private ResponseEntity<?> saveProyect(@RequestBody Projects proyect) {
        Projects projects = null;

        try {
            if (studentDetailsService.existStudent(proyect.getIdUserDetails())) {
                projects = projectService.saveProject(proyect);
                return new ResponseEntity<>(Mensaje.builder().mensaje("").object(projects).build(), HttpStatus.CREATED);

            }
            return new ResponseEntity<>(Mensaje.builder().mensaje("El usuario no existe").object(null).build(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(Mensaje.builder().mensaje(e.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("proyectos/{id}")
    private ResponseEntity<?> updateProyect(@RequestBody Projects proyect, @PathVariable Integer id) {
        Projects projects = null;
        try {
            if (projectService.existsProject(id)) {
                projects = projectService.saveProject(proyect);
                return new ResponseEntity<>(Mensaje.builder().mensaje("Proyecto actualizado con exito").object(projects).build(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Mensaje.builder().mensaje("El proyecto no existe").object(null).build(), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(Mensaje.builder().mensaje(e.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("proyectos/{id}")
    private ResponseEntity<?> deleteProyect(@PathVariable Integer id) {
        Projects projects = projectService.getProjectById(id);
        if (projects != null) {
            projectService.deleteProject(projects);
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(Mensaje.builder().mensaje("No se encontro el id: " + id).object(null).build(), HttpStatus.NOT_FOUND);
    }
}
