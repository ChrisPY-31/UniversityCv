package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Mappers.SocialMediaMappers;
import com.chris.userporfiles.Model.Dto.SocialMediaDto;
import com.chris.userporfiles.Model.Entity.SocialMedia;
import com.chris.userporfiles.Repository.SocialMediaRepository;
import com.chris.userporfiles.Service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaImpl implements SocialMediaService {

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    @Override
    public SocialMediaDto saveSocialMedia(SocialMediaDto socialMediaDto) {
        SocialMedia socialMedia = SocialMediaMappers.INSTANCE.toSocialMedia(socialMediaDto);
        socialMediaRepository.save(socialMedia);
        return socialMediaDto;
    }

    @Override
    public void deleteSocialMedia(SocialMediaDto socialMediaDto) {
        SocialMedia socialMedia = SocialMediaMappers.INSTANCE.toSocialMedia(socialMediaDto);
        socialMediaRepository.delete(socialMedia);
    }

    @Override
    public boolean existsSocialMedia(Integer id) {
        return socialMediaRepository.existsById(id);
    }

    @Override
    public SocialMediaDto getSocialMediaById(Integer id) {
        return socialMediaRepository
                .findById(id)
                .map(SocialMediaMappers.INSTANCE::toSocialMediaDto)
                .orElse(null);
    }
}
