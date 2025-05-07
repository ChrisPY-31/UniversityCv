package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.AptitudesDto;
import com.chris.userporfiles.Model.Entity.Aptitudes;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AptitudesMappers {

    AptitudesMappers INSTANCE = Mappers.getMapper(AptitudesMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "idProject" , target = "idProject")
    @Mapping(source = "name" , target = "nameAptitude")
    AptitudesDto toAptitudesDto(Aptitudes aptitudes);
    @InheritInverseConfiguration

    Aptitudes toAptitudes(AptitudesDto aptitudesDto);
}
