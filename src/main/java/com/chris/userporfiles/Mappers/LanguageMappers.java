package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.LanguageDto;
import com.chris.userporfiles.Model.Entity.Languages;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMappers {

    LanguageMappers INSTANCE = Mappers.getMapper(LanguageMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "idUserDetails" , target = "idUserDetails")
    @Mapping(source = "languaje" , target = "name")
    @Mapping(source = "proficiency" , target = "nivel")
    LanguageDto toLanguageDto (Languages language);
    @InheritInverseConfiguration

    Languages toLanguage (LanguageDto languageDto);
}
