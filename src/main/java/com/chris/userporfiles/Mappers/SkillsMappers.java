package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.SkillsDto;
import com.chris.userporfiles.Model.Entity.Skills;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillsMappers {

    SkillsMappers INSTANCE = Mappers.getMapper(SkillsMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "idUserDetails" , target = "idUserDetails")
    @Mapping(source = "skillName" , target = "name")
    @Mapping(source = "image" , target = "image")

    SkillsDto toSkillsDto (Skills skills);
    @InheritInverseConfiguration
    Skills toSkills (SkillsDto skillsDto);
}
