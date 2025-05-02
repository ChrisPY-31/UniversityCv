package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Entity.SocialMedia;

public interface SocialMediaService {

    SocialMedia saveSocialMedia(SocialMedia socialMedia);

    void deleteSocialMedia(SocialMedia socialMedia);

    boolean existsSocialMedia(Integer id);

    SocialMedia getSocialMediaById(Integer id);

}
