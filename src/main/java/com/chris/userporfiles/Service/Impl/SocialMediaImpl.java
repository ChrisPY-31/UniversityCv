package com.chris.userporfiles.Service.Impl;

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
    public SocialMedia saveSocialMedia(SocialMedia socialMedia) {
        return socialMediaRepository.save(socialMedia);
    }

    @Override
    public void deleteSocialMedia(SocialMedia socialMedia) {
        socialMediaRepository.delete(socialMedia);
    }

    @Override
    public boolean existsSocialMedia(Integer id) {
        return socialMediaRepository.existsById(id);
    }

    @Override
    public SocialMedia getSocialMediaById(Integer id) {
        return socialMediaRepository.findById(id).orElse(null);
    }
}
