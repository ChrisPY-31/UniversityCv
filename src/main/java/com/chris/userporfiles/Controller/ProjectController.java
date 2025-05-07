package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.ProjectsDto;
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
        List<ProjectsDto> proyect = projectService.getAllProjects();
        if (!proyect.isEmpty()) {
            return new ResponseEntity<>(Mensaje.builder().mensaje("").object(proyect).build(), HttpStatus.OK);
        }
        //corregir con las excepciones
        return new ResponseEntity<>(Mensaje.builder().mensaje("").object(null).build(), HttpStatus.NOT_FOUND);

    }

    @PostMapping("proyectos")
    private ResponseEntity<?> saveProyect(@RequestBody ProjectsDto proyectDto) {
        ProjectsDto saveProjects = null;

        try {
            if (studentDetailsService.existStudent(proyectDto.getIdUserDetails())) {
                saveProjects = projectService.saveProject(proyectDto);
                return new ResponseEntity<>(Mensaje.builder().mensaje("").object(saveProjects).build(), HttpStatus.CREATED);

            }
            return new ResponseEntity<>(Mensaje.builder().mensaje("El usuario no existe").object(null).build(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(Mensaje.builder().mensaje(e.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("proyectos/{id}")
    private ResponseEntity<?> updateProyect(@RequestBody ProjectsDto proyectDto, @PathVariable Integer id) {
        ProjectsDto updateProjects = null;
        try {
            if (projectService.existsProject(id)) {
                updateProjects = projectService.saveProject(proyectDto);
                return new ResponseEntity<>(Mensaje.builder().mensaje("Proyecto actualizado con exito").object(updateProjects).build(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Mensaje.builder().mensaje("El proyecto no existe").object(null).build(), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(Mensaje.builder().mensaje(e.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("proyectos/{id}")
    private ResponseEntity<?> deleteProyect(@PathVariable Integer id) {
        ProjectsDto deleteProjects = projectService.getProjectById(id);
        if (deleteProjects != null) {
            projectService.deleteProject(deleteProjects);
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(Mensaje.builder().mensaje("No se encontro el id: " + id).object(null).build(), HttpStatus.NOT_FOUND);
    }
}
