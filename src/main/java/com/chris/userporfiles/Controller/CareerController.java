package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.CareerDto;
import com.chris.userporfiles.Model.Entity.Career;
import com.chris.userporfiles.Model.Entity.StudentDetails;
import com.chris.userporfiles.Service.CareerService;
import com.chris.userporfiles.Service.ProjectService;
import com.chris.userporfiles.Service.StudentDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/")
@AllArgsConstructor
public class CareerController {

    private final CareerService careerService;
    private final StudentDetailsService studentDetails;

    @PostMapping("career")
    private ResponseEntity<?> saveCareer(@RequestBody CareerDto careerDto) {
        Boolean existProject = studentDetails.existStudent(careerDto.getIdUserDetails());
        CareerDto career1 = null;
        if (existProject) {
            career1 = careerService.saveCareer(careerDto);
            return new ResponseEntity<>(Mensaje
                    .builder()
                    .mensaje("Se creo con exito")
                    .object(career1)
                    .build() , HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("career/{id}")
    private ResponseEntity<?> updateCareer(@RequestBody CareerDto careerDto , @PathVariable Integer id) {

        if(careerService.existCareer(id) && careerDto.getId().equals(id)) {
            careerService.saveCareer(careerDto);
            return new ResponseEntity<>(Mensaje
                    .builder()
                    .mensaje("")
                    .object(careerDto)
                    .build() , HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("career/{id}")
    private ResponseEntity<?> deleteCareer(@PathVariable Integer id){
        CareerDto careerDto = careerService.careerId(id);

        if(careerDto != null){
            careerService.deleteCareer(careerDto);
            return ResponseEntity.ok(careerDto);
        }
        return ResponseEntity.notFound().build();
    }
}
