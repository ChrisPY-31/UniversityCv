package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.EducationDto;
import com.chris.userporfiles.Model.Entity.Education;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EducationMappers {

    EducationMappers INSTANCE = Mappers.getMapper(EducationMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "idUserDetails" , target = "idUserDetails")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "startDate" , target = "dateStart")
    @Mapping(source = "endDate", target = "dateEnd")
    EducationDto toEducationDto(Education education);
    @InheritInverseConfiguration

    Education toEducation(EducationDto educationDto);

}
