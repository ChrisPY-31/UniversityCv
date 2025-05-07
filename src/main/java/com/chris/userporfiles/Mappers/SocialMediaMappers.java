package com.chris.userporfiles.Mappers;

import com.chris.userporfiles.Model.Dto.SocialMediaDto;
import com.chris.userporfiles.Model.Entity.SocialMedia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialMediaMappers {

    SocialMediaMappers INSTANCE = Mappers.getMapper(SocialMediaMappers.class);

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "idUserDetails" , target = "idUserDetails")
    @Mapping(source = "paftformName" , target = "name")
    @Mapping(source = "socialImage" , target = "image")
    @Mapping(source = "porfileUrl", target = "urlSocial")
    SocialMediaDto toSocialMediaDto(SocialMedia socialMedia);
    @InheritInverseConfiguration

    SocialMedia toSocialMedia(SocialMediaDto socialMediaDto);
}
