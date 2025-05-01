package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Entity.StudentDetails;
import com.chris.userporfiles.Service.StudentDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class StudentsController {

    private final StudentDetailsService studentDetailsService;

    @GetMapping("students")
    private ResponseEntity<Page<StudentDetails>> getAllStudents(@RequestParam int page, @RequestParam int size) {
        Page<StudentDetails> pageStudents = studentDetailsService.getAllStudents(page , size) ;
        if(!pageStudents.isEmpty()){
            return new ResponseEntity<>(pageStudents , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("students/{id}")
    private ResponseEntity<?> getStudentById(@PathVariable int id) {
        StudentDetails student = studentDetailsService.getStudentById(id);
        if(student != null){
            return new ResponseEntity<>(Mensaje
                    .builder()
                    .mensaje("")
                    .object(student)
                    .build()
                    , HttpStatus.OK);
        }
        //aqui vamos hacer la validacion de not found exeption
        return ResponseEntity.notFound().build();
    }

    @PostMapping("students")
    private ResponseEntity<?> saveStudent(@RequestBody StudentDetails student) {
        StudentDetails saveStudent = null;
        try{
            saveStudent = studentDetailsService.saveStudent(student);
            return new ResponseEntity<>(Mensaje
                    .builder()
                    .object(saveStudent)
                    .mensaje("")
                    .build(), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("students/{id}")
    private ResponseEntity<?> updateStudent(@RequestBody StudentDetails student , @PathVariable Integer id) {
        StudentDetails updateStudent = null;
        try{
            if(studentDetailsService.existStudent(id)){
                updateStudent = studentDetailsService.saveStudent(student);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Studiante actualizado con exito")
                        .object(updateStudent).build()
                        , HttpStatus.OK);
            }
            else{
                //aqui ya nomas la exception de que no existe
                return new ResponseEntity<>("El id no existe" , HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("students")
    private ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        StudentDetails student = studentDetailsService.getStudentById(id);
        if(student != null){
            studentDetailsService.deleteStudent(student);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
}
