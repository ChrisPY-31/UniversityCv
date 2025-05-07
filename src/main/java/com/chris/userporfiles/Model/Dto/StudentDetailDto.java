package com.chris.userporfiles.Model.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDetailDto {

    private Integer id;

    private String nameStudent;

    private String lastNameStudent;

    private String imageStudent;

    private String titularStudent;

    private String locationStudent;

    private String birthStudent;

    private String descriptionStudent;

    private String positionStudent;

    private String curriculum;

    private CareerDto career;

    private List<SocialMediaDto> socialMedia;
    private List<EducationDto> education;
    private List<LanguageDto> languages;
    private List<SkillsDto> skills;
    private List<ProjectsDto> projects;


}
