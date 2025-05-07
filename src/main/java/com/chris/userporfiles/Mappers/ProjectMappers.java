package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.AptitudesDto;
import com.chris.userporfiles.Model.Dto.ProjectsDto;
import com.chris.userporfiles.Model.Entity.Aptitudes;
import com.chris.userporfiles.Model.Entity.Projects;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMappers {

    ProjectMappers INSTANCE = Mappers.getMapper(ProjectMappers.class);

    @Mapping(source = "idProjects" , target = "id")
    @Mapping(source = "idUserDetails" , target = "idUserDetails")
    @Mapping(source = "title" , target = "name")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "projectUrl" , target = "urlProject")
    @Mapping(source = "startDate" , target = "dateStart")
    @Mapping(source = "endDate" , target = "dateEnd")
    ProjectsDto toProjectDto(Projects project);
    @InheritInverseConfiguration

    Projects toProjects(ProjectsDto projectDto);

    @Mapping(source = "name" , target = "nameAptitude")
    AptitudesDto toAptitudesDto(Aptitudes aptitudes);
}
