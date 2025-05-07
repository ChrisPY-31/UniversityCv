package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.CareerDto;
import com.chris.userporfiles.Model.Entity.Career;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CareerMappers {

    CareerMappers INSTANCE = Mappers.getMapper(CareerMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "careerName" , target = "name")

    CareerDto toCareerDto(Career career);
    @InheritInverseConfiguration

    Career toCareer(CareerDto careerDto);
}
