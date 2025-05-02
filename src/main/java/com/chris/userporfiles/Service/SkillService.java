package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Entity.Skills;

public interface SkillService {
    Skills saveSkills(Skills skills);

    void deleteSkills(Skills skills);

    boolean existSkills(Integer id);

    Skills getSkillsId(Integer id);

}
