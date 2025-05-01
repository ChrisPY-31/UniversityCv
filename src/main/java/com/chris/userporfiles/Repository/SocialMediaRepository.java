package com.chris.userporfiles.Repository;

import com.chris.userporfiles.Model.Entity.SocialMedia;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaRepository extends ListCrudRepository<SocialMedia , Integer> {
}
