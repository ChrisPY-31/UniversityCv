package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.*;
import com.chris.userporfiles.Model.Entity.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentDetailMappers {

    StudentDetailMappers INSTANCE = Mappers.getMapper(StudentDetailMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "name" , target = "nameStudent")
    @Mapping(source = "lastName" , target = "lastNameStudent")
    @Mapping(source = "image" , target = "imageStudent")
    @Mapping(source = "titular" , target = "titularStudent")
    @Mapping(source = "location" , target = "locationStudent")
    @Mapping(source = "birthDate", target = "birthStudent")
    @Mapping(source = "description" , target = "descriptionStudent")
    @Mapping(source = "position" , target ="positionStudent")
    @Mapping(source = "curriculum" , target = "curriculum")
    @Mapping(source = "career" , target = "career")

    StudentDetailDto toStudentDetailDto(StudentDetails studentDetails);
    @InheritInverseConfiguration

    StudentDetails toStudentDetails(StudentDetailDto studentDetailDto);

    @Mapping(source = "languaje" , target = "name")
    @Mapping(source = "proficiency" , target = "nivel")
    LanguageDto toLanguageDto (Languages language);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "careerName" , target = "name")
    CareerDto toCareerDto(Career career);

    @Mapping(source = "paftformName" , target = "name")
    @Mapping(source = "socialImage" , target = "image")
    @Mapping(source = "porfileUrl", target = "urlSocial")
    SocialMediaDto toSocialMediaDto(SocialMedia socialMedia);


    @Mapping(source = "startDate" , target = "dateStart")
    @Mapping(source = "endDate", target = "dateEnd")
    EducationDto toEducationDto(Education education);


    @Mapping(source = "skillName" , target = "name")
    SkillsDto toSkillsDto(Skills skills);

    @Mapping(source = "idProjects" , target = "id")
    @Mapping(source = "title" , target = "name")
    @Mapping(source = "projectUrl" , target = "urlProject")
    @Mapping(source = "startDate" , target = "dateStart")
    @Mapping(source = "endDate" , target = "dateEnd")
    ProjectsDto toProjectsDto(Projects projects);

    @Mapping(source = "name" , target = "nameAptitude")
    AptitudesDto toAptitudesDto(Aptitudes aptitudes);

}
