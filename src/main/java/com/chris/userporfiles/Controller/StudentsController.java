package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.StudentDetailDto;
import com.chris.userporfiles.Model.Dto.StudentDto;
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
    private ResponseEntity<Page<StudentDto>> getAllStudents(@RequestParam int page, @RequestParam int size) {
        Page<StudentDto> pageStudents = studentDetailsService.getAllStudents(page , size) ;
        if(!pageStudents.isEmpty()){
            return new ResponseEntity<>(pageStudents , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("students/{id}")
    private ResponseEntity<?> getStudentById(@PathVariable int id) {
        StudentDetailDto student = studentDetailsService.getStudentById(id);
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
    private ResponseEntity<?> saveStudent(@RequestBody StudentDetailDto studentDetailDto) {


        StudentDetailDto saveStudent = null;
        try{
            saveStudent = studentDetailsService.saveStudent(studentDetailDto);
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
    private ResponseEntity<?> updateStudent(@RequestBody StudentDetailDto student , @PathVariable Integer id) {
        StudentDetailDto updateStudent = null;
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
        StudentDetailDto student = studentDetailsService.getStudentById(id);
        if(student != null){
            studentDetailsService.deleteStudent(student);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
}
