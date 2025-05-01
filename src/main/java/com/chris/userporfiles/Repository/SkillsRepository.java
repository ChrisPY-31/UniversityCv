package com.chris.userporfiles.Repository;

import com.chris.userporfiles.Model.Entity.Skills;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends ListCrudRepository<Skills, Integer> {
}
