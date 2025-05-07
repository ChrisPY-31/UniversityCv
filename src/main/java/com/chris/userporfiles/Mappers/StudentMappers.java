package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.*;
import com.chris.userporfiles.Model.Entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMappers {

    StudentMappers INSTANCE = Mappers.getMapper(StudentMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "name" , target = "studentName")
    @Mapping(source = "lastName" , target = "studentLastName")
    @Mapping(source = "image" , target = "studentImage")
    @Mapping(source = "career" , target = "career")


    StudentDto toStudentDto(StudentDetails studentDetails);

    StudentDetails toStudentDetails(StudentDto studentDto);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "careerName" , target = "name")
    CareerDto toCareerDto(Career career);


}
