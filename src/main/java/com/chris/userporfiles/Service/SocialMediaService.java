package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.SocialMediaDto;

public interface SocialMediaService {

    SocialMediaDto saveSocialMedia(SocialMediaDto socialMediaDto);

    void deleteSocialMedia(SocialMediaDto socialMediaDto);

    boolean existsSocialMedia(Integer id);

    SocialMediaDto getSocialMediaById(Integer id);

}
