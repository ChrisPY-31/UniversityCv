package com.chris.userporfiles.Controller;

import com.chris.userporfiles.Exception.Mensaje;
import com.chris.userporfiles.Model.Dto.SocialMediaDto;
import com.chris.userporfiles.Model.Entity.SocialMedia;
import com.chris.userporfiles.Service.ProjectService;
import com.chris.userporfiles.Service.SocialMediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class SocialMediaController {

    private final SocialMediaService socialMediaService;
    private final ProjectService projectService;

    @PostMapping("socialMedia")
    private ResponseEntity<?> saveSocialMedia(@RequestBody SocialMediaDto socialMediaDto) {
        SocialMediaDto savedSocialMediaDto = null;
        try {
            if (projectService.existsProject(socialMediaDto.getIdUserDetails())) {
                savedSocialMediaDto = socialMediaService.saveSocialMedia(socialMediaDto);
                return new ResponseEntity<>(Mensaje
                        .builder()
                        .mensaje("Red social creado con exito")
                        .object(savedSocialMediaDto)
                        .build() , HttpStatus.CREATED);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("socialMedia/{id}")
    private ResponseEntity<?> updateSocialMedia(@PathVariable Integer id, @RequestBody SocialMediaDto socialMediaDto) {

        SocialMediaDto socialDto = null;
        try{
            if(socialMediaService.existsSocialMedia(id) && socialMediaDto.getId().equals(id)){
                socialDto = socialMediaService.saveSocialMedia(socialMediaDto);
                return new ResponseEntity<>(Mensaje.builder().mensaje("Actualizado con exito").object(socialDto).build() , HttpStatus.OK);
            }
            return ResponseEntity.badRequest().body("El id no se encontro" + id);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("socialMedia/{id}")
    private ResponseEntity<?> deleteSocialMedia(@PathVariable Integer id) {
        SocialMediaDto socialMediaDto = socialMediaService.getSocialMediaById(id);
        if(socialMediaDto != null) {
            socialMediaService.deleteSocialMedia(socialMediaDto);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
